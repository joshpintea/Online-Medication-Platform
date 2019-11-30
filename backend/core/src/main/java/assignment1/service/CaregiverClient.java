package assignment1.service;

import core.soap_web_services.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigInteger;

public class CaregiverClient extends WebServiceGatewaySupport {

    public StringArray sayHello() {

        HelloWorldService helloWorldService = new HelloWorldService();

        Application application = helloWorldService.getApplication();
        return application.sayHello("josh", BigInteger.TEN);

//        ObjectFactory objectFactory = new ObjectFactory();
//        SayHello request = objectFactory.createSayHello();
//        request.setName(objectFactory.createSayHelloName("Josh"));
//        request.setTimes(objectFactory.createSayHelloTimes(BigInteger.TEN));
//
//        return (SayHelloResponse)getWebServiceTemplate().marshalSendAndReceive("http://localhost:8000/wsdl/", request);
    }
}
