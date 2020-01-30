package org.messenger.hooker.models.viber;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @SerializedName("")
    private int id;

    @SerializedName("id")
    @JoinColumn(name = "user_id")
    private String uuid;
    private String name;
    private String avatar;
    private String language;
    private String country;
    private String api_version;


    public String getId() {
        return uuid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", api_version='" + api_version + '\'' +
                '}';
    }
}
