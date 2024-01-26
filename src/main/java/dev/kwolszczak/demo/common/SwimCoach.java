package dev.kwolszczak.demo.common;

//no @Component annotation - for purpose . It's 3rd party library, we don't have access to this code
//it can be added as jar file from external repo
public class SwimCoach implements Coach {
    public SwimCoach() {
        System.out.println("Initialization Spring Bean - spring class : SwimCoach");
    }

    @Override
    public String getDailyWorkout() {
        return "SwimCoach: Swim 1000 meters as a warm up";
    }
}
