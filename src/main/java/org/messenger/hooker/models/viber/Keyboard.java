package org.messenger.hooker.models.viber;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Setter
public class Keyboard {
    private String type;

    public void setButtons(ArrayList<Button> buttons) {
        Buttons = buttons;
    }


    @Override
    public String toString() {
        return "Keyboard{" +
                "type='" + type + '\'' +
                ", DefaultHeight=" + DefaultHeight +
                ", Buttons=" + Buttons +
                '}';
    }

    public void setDefaultHeight(Boolean defaultHeight) {
        DefaultHeight = defaultHeight;
    }

    private Boolean DefaultHeight;
    private ArrayList<Button> Buttons;


}
