package assignment1.controller;

import assignment1.dto.DrugDto;
import assignment1.exception.ObjectNotFound;
import assignment1.service.CrudService;
import assignment1.util.EndpointsUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = EndpointsUtil.DRUG)
public class DrugController {
    private CrudService<DrugDto> drugService;

    public DrugController(CrudService<DrugDto> drugService) {
        this.drugService = drugService;
    }

    @GetMapping
    public List<DrugDto> getAll() {
        return this.drugService.getAll();
    }

    @GetMapping(value = "/{id}")
    public DrugDto getOne(@PathVariable("id") Long id) throws ObjectNotFound {
        return this.drugService.getOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws ObjectNotFound {
        this.drugService.delete(id);
    }

    @PostMapping
    public DrugDto save(@RequestBody DrugDto drugDto) throws Exception {
        return this.drugService.save(drugDto);
    }
}