package assignment1.controller;

import assignment1.service.CaregiverClient;
import core.soap_web_services.StringArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private CaregiverClient caregiverClient;

    public TestController(CaregiverClient caregiverClient) {
        this.caregiverClient = caregiverClient;
    }

    @GetMapping
    public StringArray test()  {
        return caregiverClient.sayHello();
    }
}
