package assignment3.rmiclient.config;

import assignment1.service.pildispenser.PillDispenser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class RmiProxyConfig {

    @Bean
    RmiProxyFactoryBean service() {
        RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
        rmiProxyFactory.setServiceUrl("rmi://localhost:1099/PillDispenser");
        rmiProxyFactory.setServiceInterface(PillDispenser.class);
        return rmiProxyFactory;
    }

}
