package one.team.service.Impl;

import lombok.AllArgsConstructor;
import one.team.dto.AnswerOrderDto;
import one.team.dto.CourseDto;
import one.team.dto.NewOrderDTO;
import one.team.dto.OrderDTO;
import one.team.entity.Course;
import one.team.error.NotFoundException;
import one.team.mapper.CourseMapper;
import one.team.mapper.OrderMapper;
import one.team.repository.CourseRepository;
import one.team.repository.OrderRepository;
import one.team.client.CourseServiceClient;
import one.team.service.OrderService;
import one.team.client.PaymentNotificationServiceClient;
import org.springframework.stereotype.Service;
import one.team.entity.Order;
import one.team.dto.OrderDTO;

import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

  //  private final UserServiceClient userServiceClient;
    private final PaymentNotificationServiceClient paymentNotificationServiceClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;


    @Override
    public NewOrderDTO createOrder(NewOrderDTO newOrderDTO) {
//        if (!userServiceClient.isAuthenticated(orderDTO.userId())){
//            try {
//                throw new AuthException("Юзер не авторизован");
//            } catch (AuthException e) {
//                throw new RuntimeException(e);
//            }
//        }

        Order order = orderMapper.orderDTOToOrder(newOrderDTO);
        Order newOrder = orderRepository.save(order);

        String s = paymentNotificationServiceClient.notifyPayment(newOrderDTO);
        newOrderDTO.setLink(s);
        newOrderDTO.setOrderId(newOrder.getId());
        return newOrderDTO;
    }

    @Override
    public void updateOrderStatus(long id) {
//        if (!userServiceClient.isAuthenticated(orderDTO.userId())){
//            try {
//                throw new AuthException("Юзер не авторизован");
//            } catch (AuthException e) {
//                throw new RuntimeException(e);
//            }
//        }
        Optional<Order> orderOptional = orderRepository.findById(id);
        Order orderToUpdate = orderOptional.orElseThrow(() -> new IllegalArgumentException("Заказ с указанным ID не найден"));

        orderToUpdate.setPaid(true);

        orderRepository.save(orderToUpdate);
    }

  @Override
  public AnswerOrderDto getOrder(long id) {
      Order order = orderRepository.findById(id).orElseThrow();
      Course course = courseRepository.findById(order.getCourseId()).orElseThrow(() ->
          new NotFoundException(String.format("course with id=%d is not found", order.getCourseId())));
      AnswerOrderDto orderDTO = new AnswerOrderDto(order.getId(), order.getUserId(), courseMapper.toCourseDto(course), order.isPaid());
    return orderDTO;
  }


}
