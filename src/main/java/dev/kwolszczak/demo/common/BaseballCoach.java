package dev.kwolszczak.demo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //this component fill have priority in dependency injection
@Lazy //initialize it only when it's need during DJ
public class BaseballCoach implements Coach{
    public BaseballCoach() {
        System.out.println("Initialization Spring Bean - spring class : BaseballCoach");
    }

    @Override
    public String getDailyWorkout() {
        return "Your BaseballCoach: Spend 30 minutes in batting practice";
    }
}
