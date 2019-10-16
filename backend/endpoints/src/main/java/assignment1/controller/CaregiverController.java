package assignment1.controller;


import assignment1.dto.CaregiverDto;
import assignment1.dto.PatientDto;
import assignment1.exception.ObjectNotFound;
import assignment1.exception.UsernameIsTaken;
import assignment1.service.CrudService;
import assignment1.service.caregiver.CaregiverService;
import assignment1.util.EndpointsUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = EndpointsUtil.CAREGIVER)
public class CaregiverController {
    private CrudService<CaregiverDto> caregiverCrudService;
    private CaregiverService caregiverService;

    public CaregiverController(CrudService<CaregiverDto> caregiverCrudService, CaregiverService caregiverService) {
        this.caregiverCrudService = caregiverCrudService;
        this.caregiverService = caregiverService;
    }

    @GetMapping
    public List<CaregiverDto> getAll() {
        return this.caregiverCrudService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CaregiverDto getOne(@PathVariable("id") Long id) throws ObjectNotFound {
        return this.caregiverCrudService.getOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws ObjectNotFound {
        this.caregiverCrudService.delete(id);
    }

    @PostMapping
    public CaregiverDto save(@RequestBody CaregiverDto caregiverDto) throws UsernameIsTaken {
        return this.caregiverCrudService.save(caregiverDto);
    }

    @GetMapping(value=EndpointsUtil.CAREGIVER_PATIENTS)
    public List<PatientDto> getCaregiverPatient(@PathVariable("id") Long id) throws ObjectNotFound {
        return this.caregiverService.getPatientsOfCaregiver(id);
    }
}