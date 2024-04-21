package one.team.service;

import one.team.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@FeignClient(name = "payment-notification-service")
public interface PaymentNotificationServiceClient {

    @PostMapping("/payment/notify")
    void notifyPayment(OrderDTO orderDTO);
}
