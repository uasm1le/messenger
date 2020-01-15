package org.messenger.hooker.models.viber;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sender {
    private String Name;
    private String avatar;

    @Override
    public String toString() {
        return "Sender{" +
                "Name='" + Name + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
