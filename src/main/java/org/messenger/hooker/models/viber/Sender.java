package org.messenger.hooker.models.viber;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sender {
    @Value("${viber.sender.username}")
    private String name;

    @Value("${viber.sender.avatar}")
    private String avatar;

    @Override
    public String toString() {
        return "Sender{" +
                "Name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
