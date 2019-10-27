package assignment1.rabbitmqlistener;

import assignment1.service.activity.ActivityService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerListener {

    private static final String QUEUE_NAME = "pilot";

    private ActivityService activityService;

    public ConsumerListener(ActivityService activityService) {
        this.activityService = activityService;
    }

    @RabbitListener(queues = QUEUE_NAME)
    public void listen(String in) {
        System.out.println("Message read from myQueue : " + in);

        this.activityService.processDataFromSensor(in);
    }
}
