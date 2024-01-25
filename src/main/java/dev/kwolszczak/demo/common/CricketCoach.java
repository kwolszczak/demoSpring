package dev.kwolszczak.demo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("Initialization Spring Bean - spring class : CricketCoach");

    }

    @Override
    public String getDailyWorkout() {
        return "Your CricketCoach: Practise fast bowling for 15 minutes";
    }
}
