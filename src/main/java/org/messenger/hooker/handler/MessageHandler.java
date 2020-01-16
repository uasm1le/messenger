package org.messenger.hooker.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.messenger.hooker.models.viber.IncomingMessage;
import org.messenger.hooker.models.viber.OutgoingMessage;
import org.springframework.beans.factory.annotation.Autowired;


@NoArgsConstructor
public class MessageHandler implements MessageHandlerInterface {
    String START_CONVERSATION = "conversation_started";

    private IncomingMessage incomingMessage;

    @Autowired
    private OutgoingMessage outgoingMessage;

    @Override
    public MessageHandler setMessage(IncomingMessage incomingMessage) {
        this.incomingMessage = incomingMessage;
        outgoingMessage.setReceiver(incomingMessage.getUser().getId());
        return this;
    }

    @Override
    public MessageHandler chooseEventFlow() {
        String event = incomingMessage.getEvent();
        if (event != null && event.equals(START_CONVERSATION)) {
            eventStartConversation();
        } else {
            outgoingMessage.setText("Sorry, I dont know what todo.").setType("text");
        }
        return this;
    }


    private void eventStartConversation() {
        outgoingMessage.setText("Hello").setType("text");
    }

    @Override
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
