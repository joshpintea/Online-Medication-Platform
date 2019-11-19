package assignment3.rmiclient;

import assignment1.service.pildispenser.PillDispenser;
import assignment3.rmiclient.presentation.View;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RmiClientApplication {

    public static void main(String[] args) {

        SpringApplicationBuilder builder = new SpringApplicationBuilder(RmiClientApplication.class);
        builder.headless(false);

        ConfigurableApplicationContext context = builder.run(args);

        View view = context.getBean(View.class);
//        List<MedicationPlanDto> medicationsPlan = service.getNotTakenMedicationPlans(2L);
//        System.out.println(medicationsPlan);
//        System.out.println(medicationsPlan);
//        for (MedicationPlanDto medicationPlanDto: medicationsPlan) {
//            try {
//                service.takeMedication(medicationPlanDto);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
    }

}
