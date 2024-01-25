package dev.kwolszczak.demo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("Initialization Spring Bean - spring class : tennisCoach");

    }

    @Override
    public String getDailyWorkout() {
        return "Your TennisCoach: Practice your backand volley";
    }
}
