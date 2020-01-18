package org.messenger.hooker.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@NoArgsConstructor
public class SendController {
    @Autowired
    private RestTemplate restTemplate;
    private String url;
    private HttpMethod method;

    public SendController(String url, HttpMethod method, HttpHeaders headers, String body) {
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = body;
    }

    public void init(String url, HttpMethod method, HttpHeaders headers, String body) {
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = body;
    }

    private HttpHeaders headers;
    private String body;


    public String sendRequest() {
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(url, method, entity, String.class).getBody();
    }


}
