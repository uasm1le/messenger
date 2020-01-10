package org.messenger.hooker.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MessengerController {
    @RequestMapping("/")
    public String DefaultAnswer() {
        return "Hello from Message API WebHook";
    }

    //editMessage
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public String postMessage() {
        return "Hello from Message API WebHook";
    }

    //view message by guid
    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)

    public String getMessage() {
        return "Hello from GET \"message\"  Message API WebHook";
    }



}
