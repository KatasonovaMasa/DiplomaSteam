package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Achievements {
    private Achievementpercentages Achievementpercentages;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Achievementpercentages {
        private ArrayList<Achievement> achievements;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Achievement {
        private String name;
        private double percent;
    }
}
