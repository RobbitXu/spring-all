package com.spring.kafka.provider;


import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**
 * Created by admin on 2019/2/18.
 */
public class SendDemo {

    public void init(){
        Properties kafkaProps = new Properties();
        kafkaProps.setProperty("bootstrap.servers","192.168..174.131:9092");
        kafkaProps.setProperty("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.setProperty("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String,String> producer = new KafkaProducer(kafkaProps);
        ProducerRecord producerRecord = new ProducerRecord("test.topic","a","a");
        producer.send(producerRecord,new CallbackDemo());
    }
}


class CallbackDemo implements Callback{

    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        System.out.println("finish!");
    }
}
