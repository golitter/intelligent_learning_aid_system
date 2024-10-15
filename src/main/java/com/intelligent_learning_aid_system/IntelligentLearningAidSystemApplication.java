package com.intelligent_learning_aid_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class IntelligentLearningAidSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntelligentLearningAidSystemApplication.class, args);
    }

}
