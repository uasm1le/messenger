package org.messenger.hooker.handler;

import lombok.NoArgsConstructor;
import org.messenger.hooker.models.viber.IncomingMessage;
import org.messenger.hooker.models.viber.OutgoingMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;


@NoArgsConstructor
public class MessageHandler implements MessageHandlerInterface {
    final String START_CONVERSATION = "conversation_started";
    final String MESSAGE = "message";


    private IncomingMessage incomingMessage;

    @Autowired
    private OutgoingMessage outgoingMessage;
    @Autowired
    private ViberSenderHandler responseHandler;



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


        if (event != null) {
            switch (event) {
                case (START_CONVERSATION): {
                    String chatId = (incomingMessage.getUser() != null) ? incomingMessage.getUser().getId() : null;
                    if (chatId != null) {
                        eventStartConversation();
                    }
                    break;
                }
                case (MESSAGE): {
                    ParsingMessage();
                    break;
                }
            }
        }

        return this;
    }

    private void ParsingMessage() {
        String describe = "Я только появился на свет, и не понимаю всего, что ты мне пишешь. Но я выучусь, обязательно.  ";
        String name = incomingMessage.getSender().getName();
        name = (name == null) ? "друг" : name;
        String bodyText = "Прости " + name + "." + "\n" + describe;

        bodyText = new String(bodyText.getBytes(Charset.forName("UTF-8")), Charset.forName("ISO8859-1"));
        outgoingMessage.setText(bodyText);
        outgoingMessage.setType("text");
        outgoingMessage.setReceiver(incomingMessage.getSender().getId());
        responseHandler.sendAnswer();

    }


    private void eventStartConversation() {
        String describe = "Это бот при помощи которого твоя жизнь станет проще ! Выбирай варианты внизу.";
        String name = incomingMessage.getUser().getName();
        name = (name == null) ? "друг" : name;
        String bodyText = "Привет " + name + "!" + "\n" + describe;
        System.out.println(bodyText);
        bodyText = new String(bodyText.getBytes(Charset.forName("UTF-8")), Charset.forName("ISO8859-1"));
        outgoingMessage.setText(bodyText);
        outgoingMessage.setType("text");
        outgoingMessage.setReceiver(incomingMessage.getSender().getId());
        responseHandler.sendAnswer();
    }


    @Override
    public String toString() {
        return "MessageHandler{" +
                "outgoingMessage=" + outgoingMessage +
                '}';
    }
}
