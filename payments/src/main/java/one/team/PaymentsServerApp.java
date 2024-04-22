package one.team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaymentsServerApp {

    public static void main(String[] args) {
        SpringApplication.run(PaymentsServerApp.class, args);
    }
}