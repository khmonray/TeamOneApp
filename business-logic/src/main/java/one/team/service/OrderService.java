package one.team.service;

import one.team.dto.AnswerOrderDto;
import one.team.dto.NewOrderDTO;

public interface OrderService {

    NewOrderDTO createOrder(NewOrderDTO orderDTO);
    void updateOrderStatus(long id);

    AnswerOrderDto getOrder(long id);
}
