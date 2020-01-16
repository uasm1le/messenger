package org.messenger.hooker.models.viber;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncomingMessage {

    @NotNull
    private String event;
    private String timestamp;
    private String chat_hostname;
    private Number message_token;
    private String type;
    @Autowired
    private User user;
    private Boolean subscribed;


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


}
