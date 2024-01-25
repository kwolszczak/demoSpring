package dev.kwolszczak.demo.controller;

import dev.kwolszczak.demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //@Autowired //3. option of dependency injection by field. Not recommended, legacy
    private final Coach myCoach;

    @Autowired //1. option of dependency injection by constructor. Recommended
    //Qualifier is to chose between different implementation for injection
    public DemoController(@Qualifier("tennisCoach") Coach myCoach) {
        this.myCoach = myCoach;
    }
/*    @Autowired //This one will use @Primary @component injection
    public DemoController(Coach myCoach) {
        this.myCoach = myCoach;
    }*/

/*    @Autowired //2. option of dependency injection by setter
    public void setCoach(Coach myCoach) {
        this.myCoach = myCoach;
    }*/

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
