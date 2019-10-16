package assignment1.controller;

import assignment1.dto.MedicationPlanDto;
import assignment1.dto.PatientDto;
import assignment1.exception.ObjectNotFound;
import assignment1.exception.UsernameIsTaken;
import assignment1.service.CrudService;
import assignment1.service.patient.PatientService;
import assignment1.util.EndpointsUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = EndpointsUtil.PATIENT)
public class PatientController {
    private CrudService<PatientDto> patientCrudService;
    private PatientService patientService;

    public PatientController(CrudService<PatientDto> patientCrudService, PatientService patientService) {
        this.patientCrudService = patientCrudService;
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientDto> getAll() {
        return this.patientCrudService.getAll();
    }

    @GetMapping(value = "/{id}")
    public PatientDto getOne(@PathVariable("id") Long id) throws ObjectNotFound {
        return this.patientCrudService.getOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws ObjectNotFound {
        this.patientCrudService.delete(id);
    }

    @PostMapping
    public PatientDto save(@RequestBody PatientDto patientDto) throws UsernameIsTaken {
        return this.patientCrudService.save(patientDto);
    }

    @GetMapping(value = EndpointsUtil.PATIENT_GET_MEDICATIONS_PLAN)
    public List<MedicationPlanDto> getMedicationsPlan(@PathVariable("patient_id") Long id) throws ObjectNotFound {
        return this.patientService.getMedicationsPlanByPatient(id);
    }
}
