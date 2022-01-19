package com.yunussen.kafkademo.kafka;

import com.yunussen.kafkademo.kafka.configuration.KafkaLogProperties;
import com.yunussen.kafkademo.kafka.model.KafkaLogModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaLog {

    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaLog.class);

    @Autowired
    private KafkaTemplate<String,KafkaLogModel> kafkaTemplate;
    @Autowired
    private KafkaLogProperties kafkaLogProperties;

    public void log(KafkaLogModel model){
        try{
            kafkaTemplate.send(kafkaLogProperties.getTopic(),model);
        }catch (Exception e){
            LOGGER.error("An error occurred while sending log",e);
        }
    }
}
