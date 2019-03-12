package com.jk.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @program: es
 * @description:
 * @author: 孙佳
 * @create: 2019-01-18 11:22
 **/
@Component
public class KafkaConsumer {

    @KafkaListener(topics = {"kafkasend"})
    public void receive(String message){
        System.out.println("kafkasend--消费消息:" + message);
    }
}
