package dev.kwolszczak.demo.sport.rest;

import dev.kwolszczak.demo.sport.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//  @RequestMapping("/main")  //mapowanie, na dodatkowy adres dla endpoint : localhost:port/app-properties/main
public class DemoController {

    //@Autowired //3. option of dependency injection by field. Not recommended, legacy
    private final Coach myCoach;
    //By default spring using Singleton Bean scope - czyli tworzac bean/component tworzona jest tylko jedna instancja
    //wszystkie obiekty wskazuja na ten sama instancje
    private final Coach anotherCoach;

    @Autowired //1. option of dependency injection by constructor. Recommended
    //Qualifier is to chose between different implementation for injection
    public DemoController(@Qualifier("tennisCoach") Coach myCoach,
                          @Qualifier("tennisCoach") Coach anotherCoach) {
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
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
        System.out.println("If scope of Beans is true it's singleton:"+(myCoach==anotherCoach));
        return myCoach.getDailyWorkout();
    }
}
