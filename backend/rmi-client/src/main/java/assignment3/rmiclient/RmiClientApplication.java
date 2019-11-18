package assignment3.rmiclient;

import assignment1.dto.MedicationPlanDto;
import assignment1.service.pildispenser.PillDispenser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import java.util.List;

@SpringBootApplication
public class RmiClientApplication {

    @Bean
    RmiProxyFactoryBean service() {
        RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
        rmiProxyFactory.setServiceUrl("rmi://localhost:1099/PillDispenser");
        rmiProxyFactory.setServiceInterface(PillDispenser.class);
        return rmiProxyFactory;
    }

    public static void main(String[] args) {

        PillDispenser service = SpringApplication.run(RmiClientApplication.class, args).getBean(PillDispenser.class);
        List<MedicationPlanDto> medicationsPlan = service.getActiveMedicationsPlanForPatient(1L);
        System.out.println(medicationsPlan);
    }

}
