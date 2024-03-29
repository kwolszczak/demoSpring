package dev.kwolszczak.demo.sport.config;

import dev.kwolszczak.demo.sport.common.Coach;
import dev.kwolszczak.demo.sport.ext.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // use configuration to use 3rd party componnents without @component annotation
//for dependency injection, now U can use swimCoach @Bean was registred
public class SportConfig {

    @Bean("aquatic") //take existing 3rd party class and expose as a Spring bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
