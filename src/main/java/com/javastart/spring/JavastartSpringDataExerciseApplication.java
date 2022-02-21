package com.javastart.spring;

import com.javastart.spring.devicerent4.app.ApplicationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavastartSpringDataExerciseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JavastartSpringDataExerciseApplication.class,args);
        ApplicationController applicationController = context.getBean(ApplicationController.class);
        applicationController.mainLoop();
    }

}
