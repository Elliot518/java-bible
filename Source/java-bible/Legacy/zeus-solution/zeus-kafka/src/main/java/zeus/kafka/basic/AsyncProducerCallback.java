package zeus.kafka.basic;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.Scanner;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 下午2:04 2018/3/13
 * @Modified by:
 */

class DemoProducerCallback implements Callback {
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if (e != null) {
            e.printStackTrace();
        }
    }
}

public class AsyncProducerCallback {
    public static void main(String[] args) {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer producer = new KafkaProducer<String, String>(kafkaProps);

        ProducerRecord<String, String> record;
        try {
            while (true) {
                Scanner s = new Scanner(System.in);
                String line = s.nextLine();
                if (line.equals("exit")) {
                    break;
                }
                record = new ProducerRecord<>("genesis", "test callback", line);
                producer.send(record);
                //System.out.println(line);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

