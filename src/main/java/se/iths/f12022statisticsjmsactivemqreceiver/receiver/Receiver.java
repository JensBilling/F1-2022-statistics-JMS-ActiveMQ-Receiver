package se.iths.f12022statisticsjmsactivemqreceiver.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import se.iths.f12022statisticsjmsactivemqreceiver.config.JmsConfig;
import se.iths.f12022statisticsjmsactivemqreceiver.model.MessageObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Component
public class Receiver {

    @JmsListener(destination = JmsConfig.F12022STATS_QUEUE)
    public void listen(@Payload String message
    ) throws IOException {
        System.out.println("I got a JMS message.");
        System.out.println("Added " + message + " to race database");

        File raceFile = new File("races.txt");
        Scanner raceScanner = new Scanner(raceFile);
        String previousRaceData = "";
        while (raceScanner.hasNext()){
            previousRaceData += raceScanner.nextLine() + "\n";
        }
        raceScanner.close();

        FileWriter writer = new FileWriter("races.txt");
        writer.write(previousRaceData + "Added " + message + " to race database");
        writer.close();

    }
}
