package com.facundoduarte.mvc.mvc.services;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Message;
import com.facundoduarte.mvc.mvc.repositories.MessageRepository;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }
}
