package dev.kwolszczak.demo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //new object is createg for new injection, for default-singleton only one object is created
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("Initialization Spring Bean - spring class : tennisCoach");

    }

    @Override
    public String getDailyWorkout() {
        return "Your TennisCoach: Practice your backand volley";
    }
}
