package org.messenger.hooker.controllers;


import com.google.gson.Gson;
import org.messenger.hooker.handler.MessageHandler;
import org.messenger.hooker.handler.TelegramSenderHandler;
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
    TelegramSenderHandler telegramSenderHandler;


    @Autowired
    IncomingMessage incomingMessage;

    @RequestMapping("/")
    public String CommonHandler(@RequestBody String body) {
        telegramSenderHandler.setBody(body).logSend("Request is :");
        Gson gson = new Gson();
        incomingMessage = gson.fromJson(body, IncomingMessage.class);
        messageHandler = messageHandler.setMessage(incomingMessage).chooseEventFlow();

        return "";
    }

}
