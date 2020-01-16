package org.messenger.hooker.handler;

import org.messenger.hooker.models.viber.IncomingMessage;


public interface MessageHandlerInterface {
    MessageHandler chooseEventFlow();

    MessageHandler setMessage(IncomingMessage incomingMessage);


}
