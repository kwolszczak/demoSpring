package dev.kwolszczak.demo.thymeleaf.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class CourseCodeConstraintValidator implements ConstraintValidator <CourseCode,String>{

    private String coursePrefix;
    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        boolean result = false;
        if (!theCode.isEmpty()) {
            result = theCode.startsWith(coursePrefix);
        } else {
            result = false;
        }

        return result;
    }
}
