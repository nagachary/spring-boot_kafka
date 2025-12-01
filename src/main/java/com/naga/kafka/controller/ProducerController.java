package com.naga.kafka.controller;

import com.naga.kafka.service.Producer;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private Producer producer;

    @PostMapping("/send")
    public String publishMessage(@PathVariable ("message") final String message) {
        producer.sendMessage(message);
        return "Published the message successfully.";
    }
}
