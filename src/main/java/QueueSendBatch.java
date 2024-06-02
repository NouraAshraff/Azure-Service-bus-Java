import com.azure.messaging.servicebus.*;
import com.azure.identity.*;

import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.List;
public class QueueSendBatch {

    static String connectionString = "Endpoint=sb://demoservicebus1111.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=SzJAl9eZmAs4XnSxNa9AwgBWFOVrJeB+J+ASbFj/RtY=";
    static String queueName = "demoqueue5";

    public static void main(String[] args) {

        sendMessageBatch();
    }
    static List<ServiceBusMessage> createMessages (){
        ServiceBusMessage [] messages = {
                new ServiceBusMessage("Message A from Noura"),
                new ServiceBusMessage("Message B from Noura"),
                new ServiceBusMessage("Message C from Noura")
        };
        return Arrays.asList(messages);
    }
    static void sendMessageBatch (){
        ServiceBusSenderClient serviceBusSenderClient = new ServiceBusClientBuilder()
                .connectionString(connectionString)
                .sender()
                .queueName(queueName)
                .buildClient();

        ServiceBusMessageBatch messageBatch = serviceBusSenderClient.createMessageBatch();

        List<ServiceBusMessage> messageList = createMessages();

        //add messages to message Batch
        for(ServiceBusMessage message : messageList){
            messageBatch.tryAddMessage(message);
        }

        serviceBusSenderClient.sendMessages(messageBatch);
        System.out.println(" Batch Sent successfully");
        serviceBusSenderClient.close();

    }

}
