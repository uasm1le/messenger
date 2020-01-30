package org.messenger.hooker;

import org.messenger.hooker.controllers.SendController;
import org.messenger.hooker.handler.ViberMessageProcessor;
import org.messenger.hooker.handler.TelegramSenderHandler;
import org.messenger.hooker.handler.ViberSenderHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.servlet.annotation.WebListener;

@Configuration
@WebListener
public class HookerContextConfiguration {
    final String scopeType = "request";
    private int count = 1;





    @Bean(name = "messageHandler")
    public ViberMessageProcessor getMessageHandler() {
        return new ViberMessageProcessor();
    }

    @Bean(name = "responseHandler")
    public ViberSenderHandler getResponseHandler() {
        return new ViberSenderHandler();
    }

    @Bean(name = "restTemplate")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean(name = "sendController")
    public SendController getSendController() {

        return new SendController();
    }

    @Bean(name = "telegramSenderHandler")
    public TelegramSenderHandler getTelegramSenderHandler() {

        return new TelegramSenderHandler();
    }


}
