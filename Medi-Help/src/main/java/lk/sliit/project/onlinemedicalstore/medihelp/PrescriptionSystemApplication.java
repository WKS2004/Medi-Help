package lk.sliit.project.onlinemedicalstore.medihelp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrescriptionSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrescriptionSystemApplication.class, args);
        System.out.println("✅ Prescription Management System is running on http://localhost:8080/");
    }
} 