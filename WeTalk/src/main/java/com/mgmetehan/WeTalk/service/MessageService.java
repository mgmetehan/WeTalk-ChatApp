package com.mgmetehan.WeTalk.service;

import com.mgmetehan.WeTalk.model.Message;

public interface MessageService {
    Message saveMessage(Message message);

    void mailSender(Message message);
}
