package one.team.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import one.team.dto.OrderDto;
import one.team.dto.OrderStatusDto;
import one.team.feign.OrderServiceClient;
import one.team.feign.UserServiceClient;
import one.team.model.OrderStatus;
import one.team.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PaymentService {

    private UserServiceClient userServiceClient;

    private OrderStatusRepository orderStatusRepository;

    private OrderServiceClient orderServiceClient;


    public void processPayment(OrderDto orderDto) {

        String email = userServiceClient.getUserEmail(orderDto.userId());
        saveOrderStatus(orderDto, email);
    }

    public void saveOrderStatus(OrderDto orderDto, String email) {

        String confirmationLink = generateConfirmationLink();
        new OrderStatus();
        OrderStatus orderStatus = OrderStatus.builder()
                .confirmationLink(confirmationLink)
                .userEmail(email)
                .courseName(orderDto.courseName())
                .isPaid(false)
                .build();
    }

    public void confirmPayment(UUID uuid) {

        OrderStatus orderStatus = orderStatusRepository.findByConfirmationLink(uuid.toString())
                .orElseThrow(() -> new RuntimeException("OrderStatus not found"));
        orderStatus.setPaid(true);
        orderStatusRepository.save(orderStatus);

    }


    public String generateConfirmationLink() {
        UUID uuid = UUID.randomUUID();
        return "http://example.com/confirm/" + uuid;
    }
}



