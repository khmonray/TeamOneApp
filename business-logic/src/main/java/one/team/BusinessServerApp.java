package one.team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BusinessServerApp {

    public static void main(String[] args) {
        SpringApplication.run(BusinessServerApp.class, args);
    }
}