package org.messenger.hooker.controllers;


import com.google.gson.Gson;
import org.messenger.hooker.handler.MessageHandler;
import org.messenger.hooker.models.viber.IncomingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@lombok.extern.java.Log
public class MessengerController {

    @Autowired
    MessageHandler messageHandler;


    @Autowired
    IncomingMessage incomingMessage;

    @RequestMapping("/")
    public String CommonHandler(@RequestBody String body) {
        System.out.println("Request :" + body);
        Gson gson = new Gson();
        incomingMessage = gson.fromJson(body, IncomingMessage.class);
        messageHandler.setMessage(incomingMessage).chooseEventFlow();

        return "";
    }

}
