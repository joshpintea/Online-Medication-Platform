package assignment1.service.activity;

import java.util.HashMap;
import java.util.Map;

public enum ActivityRule {
    SLEEPING("Sleeping", 12),
    LEAVING("Leaving", 12),
    TOILETING("Toileting", 1),
    SHOWERING("Showering", 1)
    ;

    private final String label;
    private final Integer hours;


    private static Map<String, ActivityRule> valueToTextMapping;

    ActivityRule(String label, Integer hours) {
        this.label = label;
        this.hours = hours;
    }

    private static void initMapping(){
        valueToTextMapping = new HashMap<>();
        for(ActivityRule s : values()){
            valueToTextMapping.put(s.label, s);
        }
    }

    public static ActivityRule getRule(String activity) {
        if (valueToTextMapping ==  null) {
            initMapping();
        }

        return valueToTextMapping.get(activity);
    }

    public String getLabel() {
        return label;
    }

    public Integer getHours() {
        return hours;
    }
}
