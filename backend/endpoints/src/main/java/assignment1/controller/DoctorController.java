package assignment1.controller;

import assignment1.dto.DoctorDto;
import assignment1.exception.ObjectNotFound;
import assignment1.service.CrudService;
import assignment1.util.EndpointsUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = EndpointsUtil.DOCTOR)
public class DoctorController {
    private CrudService<DoctorDto> doctorService;

    public DoctorController(CrudService<DoctorDto> doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorDto> getAll() {
        return this.doctorService.getAll();
    }

    @GetMapping(value = "/{id}")
    public DoctorDto getOne(@PathVariable("id") Long id) throws ObjectNotFound {
        return this.doctorService.getOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws ObjectNotFound {
        this.doctorService.delete(id);
    }

    @PostMapping
    public DoctorDto save(@RequestBody DoctorDto doctorDto) {
        return this.doctorService.save(doctorDto);
    }
}
