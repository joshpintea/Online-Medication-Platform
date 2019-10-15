package assignment1.controller;

import assignment1.dto.SideEffectDto;
import assignment1.exception.ObjectNotFound;
import assignment1.service.CrudService;
import assignment1.util.EndpointsUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = EndpointsUtil.SIDE_EFFECT)
public class SideEffectController {
    private CrudService<SideEffectDto> sideEffectDtoCrudService;

    public SideEffectController(CrudService<SideEffectDto> sideEffectDtoCrudService) {
        this.sideEffectDtoCrudService = sideEffectDtoCrudService;
    }

    @GetMapping
    public List<SideEffectDto> getAll() {
        return this.sideEffectDtoCrudService.getAll();
    }

    @GetMapping(value = "/{id}")
    public SideEffectDto getOne(@PathVariable("id") Long id) throws ObjectNotFound {
        return this.sideEffectDtoCrudService.getOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws ObjectNotFound {
        this.sideEffectDtoCrudService.delete(id);
    }

    @PostMapping
    public SideEffectDto save(@RequestBody SideEffectDto sideEffectDto) {
        return this.sideEffectDtoCrudService.save(sideEffectDto);
    }
}
