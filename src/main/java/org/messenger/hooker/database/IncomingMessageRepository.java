package org.messenger.hooker.database;

import org.messenger.hooker.models.IncomingMessage;
import org.springframework.data.repository.CrudRepository;

public interface IncomingMessageRepository extends CrudRepository<IncomingMessage, Integer> {

}