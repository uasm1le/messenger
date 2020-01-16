package org.messenger.hooker;

import org.messenger.hooker.handler.MessageHandler;
import org.messenger.hooker.models.viber.IncomingMessage;
import org.messenger.hooker.models.viber.OutgoingMessage;
import org.messenger.hooker.models.viber.Sender;
import org.messenger.hooker.models.viber.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HookerContextConfiguration {

    @Bean(name = "user")
    public User getUser() {
        return new User();
    }

    @Bean(name = "sender")
    public Sender getSender() {
        return new Sender();
    }

    @Bean(name = "outgoingMessage")
    public OutgoingMessage getOutgoingMessage() {
        return new OutgoingMessage();
    }

    @Bean(name = "incomingMessage")
    public IncomingMessage getIncomingMessage() {
        return new IncomingMessage();
    }


    @Bean(name = "messageHandler")
    public MessageHandler getMessageHandler() {
        return new MessageHandler();
    }

}
