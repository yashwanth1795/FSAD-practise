package com.klu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.klu.model.CourseRegistration;

@SpringBootApplication
public class DiCrAnnotationApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(DiCrAnnotationApplication.class, args);

        CourseRegistration cr = context.getBean(CourseRegistration.class);
        cr.display();
    }
}
