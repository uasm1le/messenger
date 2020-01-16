package org.messenger.hooker.controllers;


import lombok.var;
import org.messenger.hooker.HookerApplication;
import org.messenger.hooker.handler.MessageHandler;
import org.messenger.hooker.models.viber.IncomingMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")

public class MessengerController {
    @Value("${viber.authtoken}")
    String authToken;
    @RequestMapping("/")
    public String HelloNewUser(@RequestBody IncomingMessage incomingMessageBody) {
        return new MessageHandler(incomingMessageBody).getResponse();
    }

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("X-Viber-Auth-Token", authToken);
    }


}
