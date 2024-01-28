package dev.kwolszczak.demo.sport.rest;

import dev.kwolszczak.demo.sport.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportController {

    private Coach myCoach;

    @Autowired
   // public SportController(@Qualifier("swimCoach") Coach myCoach) {
    public SportController(@Qualifier("aquatic") Coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping("/myCoach")
    public String getSportAdvice() {
        return myCoach.getDailyWorkout();
    }
}
