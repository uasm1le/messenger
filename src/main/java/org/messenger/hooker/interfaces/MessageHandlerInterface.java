package org.messenger.hooker.interfaces;

import org.messenger.hooker.handler.MessageHandler;
import org.messenger.hooker.models.viber.IncomingMessage;


public interface MessageHandlerInterface {
    MessageHandler chooseEventFlow();

    MessageHandler setMessage(IncomingMessage incomingMessage);


}
