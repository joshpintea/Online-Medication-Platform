package assignment1.controller;

import assignment1.entities.Doctor;
import assignment1.service.doctor.DoctorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping(value = "/test")
public class DoctorController {
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public Doctor test() {
        Doctor doctor = new Doctor();
        doctor.setUsername("josh");
        doctor.setPassword("josh");
        doctor.setAddress("Cluj");
        doctor.setBirthDate(new Date(1546344));
        doctor.setGender("M");
        doctor.setName("Pintea Josh");
        return this.doctorService.create(doctor);
    }
}
