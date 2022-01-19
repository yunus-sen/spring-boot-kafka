package com.yunussen.kafkademo.controller;

import com.yunussen.kafkademo.kafka.HttpUtils;
import com.yunussen.kafkademo.kafka.KafkaLog;
import com.yunussen.kafkademo.kafka.model.KafkaLogModel;
import com.yunussen.kafkademo.model.request.Person;
import com.yunussen.kafkademo.model.response.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private static final String LOG_TYPE="KAFKA-TEST-LOG";
    @Autowired
    private KafkaLog kafkaLog;

    @PostMapping("/")
    public ResponseEntity<String> getMessage(@RequestBody Person person){
        kafkaLog.log(new KafkaLogModel(
                LOG_TYPE,
                HttpUtils.getClientIpAddressIfServletRequestExist(),
                Map.of(
                        "STATUS",PersonResponse.Status.SUCCES,
                        "REQUEST",person,
                        "RESPONSE",new PersonResponse(person.getName()+person.getSurname(),PersonResponse.Status.SUCCES,PersonResponse.Status.SUCCES.getMessage())
                )

        ));
        return ResponseEntity.ok(PersonResponse.Status.SUCCES.getMessage());
    }
}
