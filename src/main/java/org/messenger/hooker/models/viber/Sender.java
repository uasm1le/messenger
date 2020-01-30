package org.messenger.hooker.models.viber;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Sender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SerializedName("")
    private int id;
    //@Value("${viber.sender.username}")
    public String getId() {
        return uuid;
    }

    @SerializedName("id")
    private String uuid;
    private String name;
    //@Value("${viber.sender.avatar}")
    private String avatar;
    private String language;
    private String country;
    @SerializedName("api_version")
    private String apiVersion;
    public Sender(String name, String avatar) {
        this.name = name;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Sender{" +
                "Name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
