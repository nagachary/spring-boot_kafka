package com.naga.kafka.controller;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    public String publishMessage(@PathVariable ("message") final String message) {

    }
}
