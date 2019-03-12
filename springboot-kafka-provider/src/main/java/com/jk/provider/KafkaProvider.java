package com.jk.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: es
 * @description:
 * @author: 孙佳
 * @create: 2019-01-18 11:00
 **/
@Controller
public class KafkaProvider {
    @Autowired
    KafkaTemplate kafkaTemplate;

    @RequestMapping("send")
    private void send(String name){
        ListenableFuture kafkasend = kafkaTemplate.send("kafkasend", name);
        kafkasend.addCallback(o -> System.out.println("send-消息发送成功：" + name), throwable -> System.out.println("消息发送失败：" + name));
    }
}
