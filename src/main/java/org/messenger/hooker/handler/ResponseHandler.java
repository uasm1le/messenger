package org.messenger.hooker.handler;


import com.google.gson.Gson;
import lombok.NoArgsConstructor;
import org.messenger.hooker.models.viber.OutgoingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@NoArgsConstructor
public class ResponseHandler implements ResponseHandlerInterface {
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
    private RestTemplate restTemplate;


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
        HttpEntity<String> entity = new HttpEntity<String>(body, headers);
        String response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
        System.out.println("Response : " + response);
        return "";
    }


    @Override
    public void sendAnswer() {
        System.out.println(send(url, type, "HEADER", new Gson().toJson(outgoingMessage)));
    }
}
