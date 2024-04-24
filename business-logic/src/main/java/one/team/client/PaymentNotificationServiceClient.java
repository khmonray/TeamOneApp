package one.team.client;

import one.team.dto.NewOrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "payments", url = "http://payments:9092")
@FeignClient(name = "payments", url = "http://localhost:9092")
public interface PaymentNotificationServiceClient {

    @PostMapping("/payments/payment/process")
    String notifyPayment(@RequestBody NewOrderDTO orderDTO);
}
