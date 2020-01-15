package org.messenger.hooker.controllers;


import org.messenger.hooker.handler.MessageHandler;
import org.messenger.hooker.models.viber.IncomingMessage;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class MessengerController {
    @RequestMapping("/")
    public String HelloNewUser(@RequestBody IncomingMessage incomingMessageBody) {

        return new MessageHandler(incomingMessageBody).getResponse();
    }

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("X-Viber-Auth-Token", "49dc47b90027d15f-379bbe201e6a23ce-5da4cb7542f5131d");

    }


}
