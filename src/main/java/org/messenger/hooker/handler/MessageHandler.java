package org.messenger.hooker.handler;

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
    @Autowired
    private ResponseHandler responseHandler;
    @Override
    public MessageHandler setMessage(IncomingMessage incomingMessage) {
        this.incomingMessage = incomingMessage;
        return this;
    }

    @Override
    public MessageHandler chooseEventFlow() {
        // check event is not null or value is normal
        String event = incomingMessage.getEvent();
        // check have we chatId in incomnig message for answer on it;
        String chatId = (incomingMessage.getUser() != null) ? incomingMessage.getUser().getId() : null;

        if (event != null && chatId != null && event.equals(START_CONVERSATION)) {
            eventStartConversation();
        }
        return this;
    }


    private void eventStartConversation() {
        outgoingMessage.setText("Hello").setType("text");
        responseHandler.sendAnswer();
    }


    @Override
    public String toString() {
        return "MessageHandler{" +
                "outgoingMessage=" + outgoingMessage +
                '}';
    }
}
