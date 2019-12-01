package assignment1.config;

import assignment1.service.doctor.DoctorSoapService;
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
    public DoctorSoapService caregiverClient(Jaxb2Marshaller marshaller) {
        DoctorSoapService doctorSoapService = new DoctorSoapService();
        doctorSoapService.setDefaultUri("http://localhost:8000/doctor_wsdl/");
        doctorSoapService.setMarshaller(marshaller);
        doctorSoapService.setUnmarshaller(marshaller);
        return doctorSoapService;
    }
}
