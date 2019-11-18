package assignment1.app;

import assignment1.service.cabbooking.CabBookingService;
import assignment1.service.cabbooking.CabBookingServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = {
        "assignment1.config",
        "assignment1.service",
        "assignment1.controller",
        "assignment1.rabbitmqlistener"
})
@EnableAuthorizationServer
public class AppApplication {

    @Bean
    CabBookingService bookingService() {
        return new CabBookingServiceImpl();
    }

    @Bean
    RmiServiceExporter exporter(CabBookingService implementation) {

        // Expose a service via RMI. Remote obect URL is:
        // rmi://<HOST>:<PORT>/<SERVICE_NAME>
        // 1099 is the default port

        Class<CabBookingService> serviceInterface = CabBookingService.class;
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceInterface(serviceInterface);
        exporter.setService(implementation);
        exporter.setServiceName(serviceInterface.getSimpleName());
        exporter.setRegistryPort(1099);
        System.out.println("Hello");
        return exporter;
    }

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
