package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@RestController
public class Application {

    @Value("${app.environment:UNKNOWN}")
    private String environment;

    public static void main(String[] args) {
        System.out.println("=== MICROSERVICE2 DEV STARTING ===");
        System.out.println("DEBUG: ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!");
        System.out.println("DEBUG: Extra DEV branch letters: HELLO WORLD ABC XYZ!");
        System.out.println("DEBUG: Current time: " + java.time.LocalDateTime.now());
        System.out.println("DEBUG: NEW DEPLOYMENT TEST - MICROSERVICE2 DEV v7.001!");
        System.out.println("DEBUG: TESTING ARGOCD AUTO DEPLOYMENT FEATURE!");
        System.out.println("DEBUG: ENHANCED LOGGING FOR CI/CD PIPELINE VERIFICATION!");
        System.out.println("DEBUG: MICROSERVICE2 READY FOR ARGOCD SYNC - FORCE TRIGGER!");
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/")
    public String hello() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                return "Hello from Microservice 222 - DEV环境自动部署测试 v7.001666 - ArgoCD Test - Current Time: " + now.format(formatter) + " (ENV: " + environment.toUpperCase() + ")";
    }
    
    @GetMapping("/health")
    public String health() {
        return "{\"status\":\"UP\",\"version\":\"6.0\",\"environment\":\"" + environment + "\",\"timestamp\":\"" + LocalDateTime.now() + "\"}";
    }
}
