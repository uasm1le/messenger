package org.messenger.hooker.handler;


import com.google.gson.Gson;
import lombok.NoArgsConstructor;
import org.messenger.hooker.controllers.SendController;
import org.messenger.hooker.models.viber.OutgoingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.util.Arrays;

@NoArgsConstructor
public class ViberSenderHandler implements ResponseHandlerInterface {
    @Autowired
    private OutgoingMessage outgoingMessage;
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


    private String send(String url, String type, String header, String body) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(url);
        System.out.println(type);
        System.out.println(header);
        System.out.println(body);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("X-Viber-Auth-Token", authToken);
        sendController.init(url, HttpMethod.POST, headers, body);
        String response = sendController.sendRequest();
        System.out.println("Response : " + response);
        return "";
    }


    @Override
    public void sendAnswer() {
        String body = new Gson().toJson(outgoingMessage);
        String response = send(url, type, "HEADER", body);
        System.out.println(response);
    }
}
