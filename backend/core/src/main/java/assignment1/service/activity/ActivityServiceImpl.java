package assignment1.service.activity;

import assignment1.dto.ActivityDto;
import assignment1.dto.mapper.ActivityMapper;
import assignment1.entities.Activity;
import assignment1.entities.Patient;
import assignment1.repository.ActivityRepository;
import assignment1.repository.PatientRepository;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;


@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

    private ActivityRepository activityRepository;
    private PatientRepository patientRepository;
    private SimpMessagingTemplate simpMessagingTemplate;

    private Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);

    public ActivityServiceImpl(ActivityRepository activityRepository, PatientRepository patientRepository,
                               SimpMessagingTemplate simpleMessagingTemplate) {
        this.activityRepository = activityRepository;
        this.patientRepository = patientRepository;
        this.simpMessagingTemplate = simpleMessagingTemplate;
    }

    private ActivityDto parseActivityFromJson(String activityAsJson) {
        ActivityDto activityModel = null;
        try {
            JSONObject obj = new JSONObject(activityAsJson);
            Date start = new Timestamp(obj.getLong("start"));
            Date end = new Timestamp(obj.getLong("end"));

            activityModel = new ActivityDto();

            activityModel.setActivityLabel(obj.getString("activity"));
            activityModel.setPatientId(obj.getLong("patient_id"));
            activityModel.setEnd(end);
            activityModel.setStart(start);

        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }

        return activityModel;
    }

    public void processDataFromSensor(String activityAsJson) {
        ActivityDto activityModel = this.parseActivityFromJson(activityAsJson);

        Patient patient = null;
        try {
            patient = this.patientRepository.getOne(activityModel.getPatientId());
        } catch (Exception ex) {
            System.out.println("Patient id " + activityModel.getPatientId() + " not found");
            return;
        }


        Activity activity = new Activity(patient, activityModel.getStart(),
                activityModel.getEnd(), activityModel.getActivityLabel(), false, true);

        // save activity into the database
        Activity activity1 = this.activityRepository.save(activity);

        this.checkActivityRuleAndNotifyCaregiver(activity1);
    }

    /**
     * Rules:
     * - the sleep period is longer than 12 hours
     * - the leaving period is longer than 12 hours
     * - the period spent in bathroom is longer than 1 hour
     *
     * @param activity
     */
    public void checkActivityRuleAndNotifyCaregiver(Activity activity) {
        ActivityRule activityRule = ActivityRule.getRule(activity.getActivityLabel());

        // no rule for the given activity
        if (activityRule == null) {
            return;
        }

        long diff = activity.getEndDate().getTime() - activity.getStartDate().getTime();
        long hours = diff / (3600000); // 100 * 60 * 60  convert from milliseconds in hours
        if (hours >= activityRule.getHours()) {
            // notify caregiver that patient break the rule

            Long caregiverId = activity.getActivityPatient().getCaregiver().getId();
            String websocketPath = "/activity/rule_violated/" + caregiverId;

            this.logger.info("Activity violated: " + activity + " hours: "
                    + hours + " caregiver username: " + activity.getActivityPatient().getCaregiver().getUsername());
            this.simpMessagingTemplate.convertAndSend(websocketPath, ActivityMapper.convertToDto(activity));
            activity.setIsViolated(true);
        }
    }


}
