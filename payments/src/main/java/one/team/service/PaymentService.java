package one.team.service;

import java.util.List;
import lombok.AllArgsConstructor;
import one.team.dto.OrderDto;
import one.team.dto.StatisticDto;
import one.team.client.OrderServiceClient;
import one.team.client.StatsServiceClient;
import one.team.client.UserServiceClient;
import one.team.model.OrderStatus;
import one.team.repository.OrderStatusRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class PaymentService {

    private UserServiceClient userServiceClient;

    private final OrderStatusRepository orderStatusRepository;

    private OrderServiceClient orderServiceClient;
    private final StatsServiceClient statsServiceClient;



  public String processPayment(OrderDto orderDto) {

       // String email = userServiceClient.getUserEmail(orderDto.userId());
        String email = "alo@mail.ru";
        return saveOrderStatus(orderDto, email);
    }

    public String saveOrderStatus(OrderDto orderDto, String email) {

        String confirmationLink = generateConfirmationLink();
        new OrderStatus();
        OrderStatus orderStatus = OrderStatus.builder()
                .confirmationLink(confirmationLink)
                .userEmail(email)
                .courseId(orderDto.courseId())
                .isPaid(false)
                .build();
        orderStatusRepository.save(orderStatus);
        return confirmationLink;
    }

  public void confirmPayment(UUID uuid) {
    List<OrderStatus> orderStatuses = orderStatusRepository.findAll();
    OrderStatus orderStatus = orderStatusRepository.findByConfirmationLink(
            "http://localhost:9092/payments/confirm/" + uuid.toString())
        .orElseThrow(() -> new RuntimeException("OrderStatus not found"));
    orderStatus.setPaid(true);
    orderStatusRepository.save(orderStatus);
    orderServiceClient.updateOrder(orderStatus.getId());
        StatisticDto statisticDto = new StatisticDto(orderStatus.getCourseId());
        statsServiceClient.sendStats(statisticDto);
    }


    public String generateConfirmationLink() {
        UUID uuid = UUID.randomUUID();
        return "http://localhost:9092/payments/confirm/" + uuid;
    }
}



