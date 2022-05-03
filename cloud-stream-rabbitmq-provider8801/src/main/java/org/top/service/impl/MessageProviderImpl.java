package org.top.service.impl;

import cn.hutool.core.lang.UUID;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.top.service.MessageProvider;

import javax.annotation.Resource;


@EnableBinding(Source.class)  // 定义消息的推送管道
public class MessageProviderImpl implements MessageProvider {

    @Resource
    private MessageChannel output; //消息发送管道

    @Override
    public String send() {
        String msg = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(msg).build());
        return msg;
    }
}
