import com.azure.messaging.servicebus.*;
import com.azure.identity.*;

import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.List;

public class QueueSendExample {

    static String connectionString = "Endpoint=sb://demoservicebus1111.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=SzJAl9eZmAs4XnSxNa9AwgBWFOVrJeB+J+ASbFj/RtY=";
    static String queueName = "demoqueue5";
    public static void main(String[] args) {
        sendMessage();
    }
    static void sendMessage(){

        ServiceBusSenderClient serviceBusSenderClient = new ServiceBusClientBuilder()
                .connectionString(connectionString)
                .sender()
                .queueName(queueName)
                .buildClient();

        serviceBusSenderClient.sendMessage(new ServiceBusMessage("Noura Ashraf Saying Hello"));
        System.out.println("message sent successfully");

    }
}
