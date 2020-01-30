package org.messenger.hooker.handler;


import com.google.gson.Gson;
import lombok.NoArgsConstructor;
import org.messenger.hooker.controllers.SendController;
import org.messenger.hooker.models.OutgoingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.util.Arrays;

@NoArgsConstructor
public class ViberSenderHandler {

    @Value("${viber.url.send_message}")
    private String url;
    @Value("${viber.url.request_type}")
    private String type;
    @Value("${viber.authtoken}")
    String authToken;
    //"X-Viber-Auth-Token"
    //
    @Autowired
    SendController sendController;

    @Autowired
    TelegramSenderHandler telegramSenderHandler;

    private String send(String url, String type, String header, String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("X-Viber-Auth-Token", authToken);
        sendController.init(url, HttpMethod.POST, headers, body);

        String response = sendController.sendRequest();
        System.out.println("Request - Response : " + body);
        System.out.println("Response : " + response);
        return response;
    }


    public void sendAnswer(OutgoingMessage outgoingMessage) {
        String body = new Gson().toJson(outgoingMessage);
        telegramSenderHandler.setBody(body).logSend("Response is :");
        String response = send(url, type, "HEADER", body);
        System.out.println(response);
    }
}
