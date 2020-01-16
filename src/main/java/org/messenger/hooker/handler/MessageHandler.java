package org.messenger.hooker.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.messenger.hooker.models.viber.IncomingMessage;
import org.messenger.hooker.models.viber.OutgoingMessage;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class MessageHandler {
    String START_CONVERSATION = "conversation_started";

    private IncomingMessage incomingMessage;
    private OutgoingMessage outgoingMessage = new OutgoingMessage();


    public MessageHandler(IncomingMessage incomingMessage) {
        this.incomingMessage = incomingMessage;
        outgoingMessage.setReceiver(incomingMessage.getUser().getId());
        chooseEventFlow();

    }

    private void chooseEventFlow() {
        String event = incomingMessage.getEvent();
        if (event != null && event.equals(START_CONVERSATION)) {
            eventStartConversation();
        } else {
            outgoingMessage.setText("Sorry, I dont know what todo.");
        }
    }

    private void eventStartConversation() {
        outgoingMessage.setText("Hello");
    }

    public String getResponse() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(outgoingMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String toString() {
        return "MessageHandler{" +
                "outgoingMessage=" + outgoingMessage +
                '}';
    }
}
