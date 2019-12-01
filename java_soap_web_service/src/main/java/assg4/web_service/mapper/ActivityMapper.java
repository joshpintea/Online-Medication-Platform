package assg4.web_service.mapper;

import assg4.web_service.util.DateUtil;
import core.recommendation_web_service.Activity;

import java.sql.Date;

public class ActivityMapper {

    public static Activity convertToXmlObject(assg4.web_service.entities.Activity at) {
        Activity activity = new Activity();
        activity.setActivityLabel(at.getActivityLabel());
        activity.setId(at.getId());
        activity.setIsNormal(at.getIsViolated());
        activity.setIsViolated(at.getIsViolated());
        activity.setEndDate(DateUtil.convertDateToXmlGregorianCalendar(new Date(at.getEndDate().getTime())));
        activity.setStartDate(DateUtil.convertDateToXmlGregorianCalendar(new Date(at.getStartDate().getTime())));

        return activity;
    }
}
