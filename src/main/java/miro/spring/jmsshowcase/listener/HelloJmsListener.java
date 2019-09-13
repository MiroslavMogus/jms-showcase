package miro.spring.jmsshowcase.listener;

import miro.spring.jmsshowcase.config.JmsConfig;
import miro.spring.jmsshowcase.model.HelloJmsMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class HelloJmsListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloJmsMessage helloJmsMessage,
                       @Headers MessageHeaders headers, Message message){

        System.out.println("Message received!");

        System.out.println(helloJmsMessage);

    }
}
