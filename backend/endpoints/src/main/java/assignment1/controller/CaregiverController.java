package assignment1.controller;


import assignment1.dto.CaregiverDto;
import assignment1.exception.ObjectNotFound;
import assignment1.service.CrudService;
import assignment1.util.EndpointsUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = EndpointsUtil.CAREGIVER)
public class CaregiverController {
    private CrudService<CaregiverDto> caregiverService;

    public CaregiverController(CrudService<CaregiverDto> caregiverService) {
        this.caregiverService = caregiverService;
    }

    @GetMapping
    public List<CaregiverDto> getAll() {
        return this.caregiverService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CaregiverDto getOne(@PathVariable("id") Long id) throws ObjectNotFound {
        return this.caregiverService.getOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws ObjectNotFound {
        this.caregiverService.delete(id);
    }

    @PostMapping
    public CaregiverDto save(@RequestBody CaregiverDto caregiverDto) {
        return this.caregiverService.save(caregiverDto);
    }
}