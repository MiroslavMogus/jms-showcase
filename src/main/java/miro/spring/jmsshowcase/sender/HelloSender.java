package miro.spring.jmsshowcase.sender;

import lombok.RequiredArgsConstructor;
import miro.spring.jmsshowcase.config.JmsConfig;
import miro.spring.jmsshowcase.model.HelloJmsMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 500)
    public void sendMessage(){

        /**
         * HelloJmsMessage which will Spring convert to JSON payload
         * before sending to message queue
         */

        System.out.println("Hello from JMS sender");
        HelloJmsMessage message = HelloJmsMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hi - JMS here!")
                .build();

        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);

        System.out.println("Message Sent!");

    }

}
