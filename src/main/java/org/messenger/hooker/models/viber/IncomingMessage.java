package org.messenger.hooker.models.viber;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Component
public class IncomingMessage {


    private String event;
    private Timestamp timestamp;
    private String chat_hostname;
    private Number message_token;
    private String type;
    @Autowired
    private User user;
    private Boolean subscribed;

    public IncomingMessage(String event, Timestamp timestamp, String chat_hostname, Number message_token, String type, User user, Boolean subscribed) {
        this.event = event;
        this.timestamp = timestamp;
        this.chat_hostname = chat_hostname;
        this.message_token = message_token;
        this.type = type;
        this.user = user;
        this.subscribed = subscribed;
    }

    public IncomingMessage() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "event='" + event + '\'' +
                ", timestamp=" + timestamp +
                ", chat_hostname='" + chat_hostname + '\'' +
                ", message_token=" + message_token +
                ", type='" + type + '\'' +
                ", user=" + user +
                ", subscribed=" + subscribed +
                '}';
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getChat_hostname() {
        return chat_hostname;
    }

    public void setChat_hostname(String chat_hostname) {
        this.chat_hostname = chat_hostname;
    }

    public Number getMessage_token() {
        return message_token;
    }

    public void setMessage_token(Number message_token) {
        this.message_token = message_token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }
}
