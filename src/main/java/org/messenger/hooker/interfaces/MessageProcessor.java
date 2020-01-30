package org.messenger.hooker.interfaces;

import org.messenger.hooker.models.IncomingMessage;


public interface MessageProcessor {
    MessageProcessor startProcess();

    MessageProcessor setMessage(IncomingMessage incomingMessage);


}
