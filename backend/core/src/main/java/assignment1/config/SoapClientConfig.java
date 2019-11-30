package assignment1.config;

import assignment1.service.CaregiverClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the  specified in
        // pom.xml
        marshaller.setContextPath("core.soap_web_services");
        return marshaller;
    }


    @Bean
    public CaregiverClient caregiverClient(Jaxb2Marshaller marshaller) {
        CaregiverClient caregiverClient = new CaregiverClient();
        caregiverClient.setDefaultUri("http://localhost:8000/wsdl/");
        caregiverClient.setMarshaller(marshaller);
        caregiverClient.setUnmarshaller(marshaller);
        return caregiverClient;
    }
}
