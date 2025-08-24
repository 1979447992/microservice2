package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@RestController
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Value("${app.environment:UNKNOWN}")
    private String environment;

    public static void main(String[] args) {
        System.out.println("=== MICROSERVICE2 DEV STARTING ===");
        System.out.println("DEBUG: ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!");
        System.out.println("DEBUG: Extra DEV branch letters: HELLO WORLD ABC XYZ!");
        System.out.println("DEBUG: Current time: " + java.time.LocalDateTime.now());
        System.out.println("DEBUG: NEW DEPLOYMENT TEST - MICROSERVICE2 DEV v7.002!");
        System.out.println("DEBUG: TESTING ARGOCD AUTO DEPLOYMENT FEATURE!");
        System.out.println("DEBUG: ENHANCED LOGGING FOR CI/CD PIPELINE VERIFICATION!");
        System.out.println("DEBUG: MICROSERVICE2 READY FOR ARGOCD SYNC - FORCE TRIGGER!");
        // Trigger CI/CD build with logging functionality
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/")
    public String hello() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        logger.info("🚀 Main endpoint accessed - Environment: {}, Timestamp: {}", 
                     environment.toUpperCase(), now.format(formatter));
        
        String response = "Hello from Microservice 222 - DEV环境自动部署测试 v7.00166623 - ArgoCD Test - Current Time: " + now.format(formatter) + " (ENV: " + environment.toUpperCase() + ")";
        
        logger.info("📊 Request processed successfully for main endpoint");
        
        return response;
    }
    
    @GetMapping("/health")
    public String health() {
        logger.info("❤️ Health check endpoint accessed - Environment: {}", environment.toUpperCase());
        
        String healthResponse = "{\"status\":\"UP\",\"version\":\"6.0\",\"environment\":\"" + environment + "\",\"timestamp\":\"" + LocalDateTime.now() + "\"}";
        
        logger.info("✅ Health check completed successfully");
        
        return healthResponse;
    }
}
