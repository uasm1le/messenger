package org.messenger.hooker.controllers;


import org.messenger.hooker.handler.MessageHandler;
import org.messenger.hooker.models.viber.IncomingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
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

    @RequestMapping("/")
    public String CommonHandler(@Validated @RequestBody IncomingMessage incomingMessageBody) {
        System.out.println(incomingMessageBody);
        return messageHandler.setMessage(incomingMessageBody).chooseEventFlow().getResponse();
    }

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("X-Viber-Auth-Token", authToken);
    }


}
