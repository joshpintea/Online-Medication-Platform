package assignment1.dto;

import java.util.List;

public class MedPlanNotObeyed {
    private MedPlanSoapDto medPlanSoapDto;
    private List<MedPlanIntervalSoapDto> intervals;

    public MedPlanNotObeyed() {
    }

    public MedPlanNotObeyed(MedPlanSoapDto medPlanSoapDto, List<MedPlanIntervalSoapDto> intervals) {
        this.medPlanSoapDto = medPlanSoapDto;
        this.intervals = intervals;
    }

    public MedPlanSoapDto getMedPlanSoapDto() {
        return medPlanSoapDto;
    }

    public void setMedPlanSoapDto(MedPlanSoapDto medPlanSoapDto) {
        this.medPlanSoapDto = medPlanSoapDto;
    }

    public List<MedPlanIntervalSoapDto> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<MedPlanIntervalSoapDto> intervals) {
        this.intervals = intervals;
    }
}
