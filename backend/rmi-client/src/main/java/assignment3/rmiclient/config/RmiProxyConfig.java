package assignment3.rmiclient.config;

import assignment1.service.pildispenser.PillDispenserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class RmiProxyConfig {

    @Bean
    RmiProxyFactoryBean service() {
        RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
        rmiProxyFactory.setServiceUrl("rmi://172.28.1.4:1099/PillDispenserService");
        rmiProxyFactory.setServiceInterface(PillDispenserService.class);
        return rmiProxyFactory;
    }

}
