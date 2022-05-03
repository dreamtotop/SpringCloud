package org.top.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.top.service.MessageProvider;

@RestController
public class SendMessageController {

    @Autowired
    private MessageProvider messageProvider;

    @GetMapping("/send/msg")
    public String sendMessage(){
        return messageProvider.send();
    }
}
