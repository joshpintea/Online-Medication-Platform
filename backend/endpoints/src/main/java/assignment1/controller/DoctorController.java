package assignment1.controller;

import assignment1.controller.requestmodels.AddRecommendationRequestBody;
import assignment1.controller.requestmodels.AnnotateActivityRequestBody;
import assignment1.dto.ActivityDto;
import assignment1.dto.DoctorDto;
import assignment1.dto.MedPlanNotObeyed;
import assignment1.dto.MedicationPlanDto;
import assignment1.exception.ObjectNotFound;
import assignment1.service.CrudService;
import assignment1.service.doctor.DoctorService;
import assignment1.service.doctor.DoctorSoapService;
import assignment1.util.EndpointsUtil;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = EndpointsUtil.DOCTOR)
public class DoctorController {
    private CrudService<DoctorDto> doctorCrudService;
    private DoctorService doctorService;
    private DoctorSoapService doctorSoapService;

    public DoctorController(CrudService<DoctorDto> doctorCrudService, DoctorService doctorService, DoctorSoapService doctorSoapService) {
        this.doctorCrudService = doctorCrudService;
        this.doctorService = doctorService;
        this.doctorSoapService = doctorSoapService;
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

    @PostMapping(value = EndpointsUtil.CREATE_MEDICATION_PLAN)
    public MedicationPlanDto createMedicationPlan(@RequestBody MedicationPlanDto medicationPlanDto) {
        return this.doctorService.createMedicationPlan(medicationPlanDto);
    }

    @GetMapping(value = "/activity_by_patient/{patientId}/{date}")
    public List<ActivityDto> getActivitiesByPatient(@PathVariable("patientId") Long patientId,
                                                    @PathVariable("date") Date date) {
        return doctorSoapService.getActivitiesByPatientId(patientId, date);
    }

    @PostMapping(value = "/annotate_activity")
    public ActivityDto annotateActivity(@RequestBody AnnotateActivityRequestBody annotateActivityRequestBody) {
        return doctorSoapService.annotateActivity(annotateActivityRequestBody.getActivityId(),
                annotateActivityRequestBody.isLabel());
    }

    @PostMapping(value = "/add_recommendation")
    public void addRecommendation(@RequestBody AddRecommendationRequestBody requestBody) {
        doctorSoapService.addRecommendation(requestBody.getActivityId(), requestBody.getMessage());
    }

    @GetMapping(value = "/get_not_obeyed_med_plan/{patientId}/{date}")
    public List<MedPlanNotObeyed> getNotObeyedMedPlan(@PathVariable("patientId") Long patientId,
                                                      @PathVariable("date") Date date) {
        return doctorSoapService.getNotObeyedMedPlan(patientId, date);
    }
}
