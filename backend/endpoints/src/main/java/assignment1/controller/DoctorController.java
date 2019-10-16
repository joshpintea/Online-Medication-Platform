package assignment1.controller;

import assignment1.dto.DoctorDto;
import assignment1.dto.MedicationPlanDto;
import assignment1.exception.ObjectNotFound;
import assignment1.service.CrudService;
import assignment1.service.doctor.DoctorService;
import assignment1.util.EndpointsUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = EndpointsUtil.DOCTOR)
public class DoctorController {
    private CrudService<DoctorDto> doctorCrudService;
    private DoctorService doctorService;

    public DoctorController(CrudService<DoctorDto> doctorCrudService, DoctorService doctorService) {
        this.doctorCrudService = doctorCrudService;
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorDto> getAll() {
        return this.doctorCrudService.getAll();
    }

    @GetMapping(value = "/{id}")
    public DoctorDto getOne(@PathVariable("id") Long id) throws ObjectNotFound {
        return this.doctorCrudService.getOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws ObjectNotFound {
        this.doctorCrudService.delete(id);
    }

    @PostMapping
    public DoctorDto save(@RequestBody DoctorDto doctorDto) throws Exception {
        return this.doctorCrudService.save(doctorDto);
    }

    @PostMapping(value=EndpointsUtil.CREATE_MEDICATION_PLAN)
    public MedicationPlanDto createMedicationPlan(@RequestBody MedicationPlanDto medicationPlanDto) {
        return this.doctorService.createMedicationPlan(medicationPlanDto);
    }
}
