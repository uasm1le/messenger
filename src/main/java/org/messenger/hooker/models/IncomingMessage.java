package org.messenger.hooker.models;


import com.google.gson.annotations.SerializedName;
import lombok.*;
import org.messenger.hooker.models.viber.Message;
import org.messenger.hooker.models.viber.Sender;
import org.messenger.hooker.models.viber.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IncomingMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private int id;

    @NotNull
    private String event;
    private String timestamp;
    private String chat_hostname;
    private long message_token;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Sender sender;
    private String type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private User user;
    private Boolean subscribed;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Message message;


}

