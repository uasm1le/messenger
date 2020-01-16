package org.messenger.hooker.controllers;


import com.google.gson.Gson;
import org.messenger.hooker.handler.MessageHandler;
import org.messenger.hooker.models.viber.IncomingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
@lombok.extern.java.Log
public class MessengerController {
    @Value("${viber.authtoken}")
    String authToken;

    @Autowired
    MessageHandler messageHandler;


    @Autowired
    IncomingMessage incomingMessage;

    @RequestMapping("/")
    public String CommonHandler(@RequestBody String body) {
        // Creates the json object which will manage the information received
        Gson gson = new Gson();
        incomingMessage = gson.fromJson(body, IncomingMessage.class);

        System.out.println(incomingMessage);
        System.out.println("======================================================");
        return messageHandler.setMessage(incomingMessage).chooseEventFlow().getResponse();
    }

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("X-Viber-Auth-Token", authToken);
    }


}
