package se.iths.f12022statisticsjmsactivemqreceiver.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import se.iths.f12022statisticsjmsactivemqreceiver.config.JmsConfig;
import se.iths.f12022statisticsjmsactivemqreceiver.model.MessageObject;

@Component
public class Receiver {

    @JmsListener(destination = JmsConfig.F12022STATS_QUEUE)
    public void listen(@Payload String message
    ){
        System.out.println("I got a message.");
        System.out.println(message);
    }
}
