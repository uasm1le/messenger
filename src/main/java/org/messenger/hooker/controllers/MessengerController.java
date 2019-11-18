package org.messenger.hooker.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MessengerController {
    @RequestMapping("/")
    public String bydefault() {
        return "Hello from API WebHook";
    }
}
