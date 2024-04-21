package one.team.service.Impl;

import jakarta.security.auth.message.AuthException;
import one.team.dto.OrderDTO;
import one.team.mapper.OrderMapper;
import one.team.repository.OrderRepository;
import one.team.service.OrderService;
import one.team.service.PaymentNotificationServiceClient;
import one.team.service.UserServiceClient;
import org.springframework.stereotype.Service;
import one.team.entity.Order;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final UserServiceClient userServiceClient;
    private final PaymentNotificationServiceClient paymentNotificationServiceClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(UserServiceClient userServiceClient, PaymentNotificationServiceClient paymentNotificationServiceClient, OrderRepository orderRepository, OrderMapper orderMapper) {
        this.userServiceClient = userServiceClient;
        this.paymentNotificationServiceClient = paymentNotificationServiceClient;
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public void createOrder(OrderDTO orderDTO) {
        if (!userServiceClient.isAuthenticated(orderDTO.userId())){
            try {
                throw new AuthException("Юзер не авторизован");
            } catch (AuthException e) {
                throw new RuntimeException(e);
            }
        }

        Order order = orderMapper.orderDTOToOrder(orderDTO);
        orderRepository.save(order);

        paymentNotificationServiceClient.notifyPayment(orderDTO);
    }

    @Override
    public void updateOrderStatus(long id, OrderDTO orderDTO) {
        if (!userServiceClient.isAuthenticated(orderDTO.userId())){
            try {
                throw new AuthException("Юзер не авторизован");
            } catch (AuthException e) {
                throw new RuntimeException(e);
            }
        }
        Optional<Order> orderOptional = orderRepository.findById(id);
        Order orderToUpdate = orderOptional.orElseThrow(() -> new IllegalArgumentException("Заказ с указанным ID не найден"));

        orderToUpdate.setPaid(orderDTO.isPaid());

        orderRepository.save(orderToUpdate);
    }


}
