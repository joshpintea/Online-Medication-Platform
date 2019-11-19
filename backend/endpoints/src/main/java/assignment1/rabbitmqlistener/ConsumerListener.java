package assignment1.rabbitmqlistener;

import assignment1.service.activity.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerListener {

    private static final String QUEUE_NAME = "pilot";

    private Logger logger = LoggerFactory.getLogger(ConsumerListener.class);
    private ActivityService activityService;

    public ConsumerListener(ActivityService activityService) {
        this.activityService = activityService;
    }

    @RabbitListener(queues = QUEUE_NAME)
    public void listen(Message in) {
        String messageAsJson = new String(in.getBody());
        this.logger.info("Message read from myQueue : " + messageAsJson);
        this.activityService.processDataFromSensor(messageAsJson);
    }
}
