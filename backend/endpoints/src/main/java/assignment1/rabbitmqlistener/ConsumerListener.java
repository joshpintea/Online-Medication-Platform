package assignment1.rabbitmqlistener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerListener {

    private static final String QUEUE_NAME = "pilot";

    @RabbitListener(queues = QUEUE_NAME)
    public void listen(String in) {
        System.out.println("Message read from myQueue : " + in);
    }
}
