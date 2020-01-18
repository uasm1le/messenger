package org.messenger.hooker.handler;


import lombok.NoArgsConstructor;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Assert;
import org.messenger.hooker.controllers.SendController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class TelegramSenderHandler {
    @Value("${telegram.url}")
    private String url;
    @Value("${telegram.chat_id}")
    private String chatId;
    @Value("${telegram.botcode}")
    private String botCode;

    private String body;
    HttpHeaders headers = new HttpHeaders();

    private String telegramSendMessageMethod = "/sendMessage";


    @Autowired
    private SendController sendController;


    public TelegramSenderHandler(String url, String chatId, String body, String botCode) {
        this.url = url;
        this.chatId = chatId;
        this.body = body;
        this.botCode = botCode;
    }

    public TelegramSenderHandler setBody(String body) {
        this.body = body;
        return this;
    }


    public String send() {
        postRequest();
        return "";
    }

    public void logSend(String messageTitle) {
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        body = messageTitle + "\n" +
                "```\n" +
                body
                + "\n```";
        postRequest();

    }

    private HttpResponse postRequest() {
        HttpClient myClient = HttpClientBuilder.create().build();
        HttpPost myConnection = new HttpPost(url + botCode + telegramSendMessageMethod);
        HttpResponse response = null;
        try {

            //Your parameter should be as..

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("chat_id", chatId));
            nameValuePairs.add(new BasicNameValuePair("parse_mode", "markdown"));
            nameValuePairs.add(new BasicNameValuePair("text", body));

//set parameters to ur URL

            myConnection.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//execute the connection
            response = myClient.execute(myConnection);
        } catch (ClientProtocolException e) {

            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return response;
    }


}
