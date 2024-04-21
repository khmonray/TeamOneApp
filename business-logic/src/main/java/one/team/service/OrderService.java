package one.team.service;

import one.team.dto.OrderDTO;

public interface OrderService {

    void createOrder(OrderDTO orderDTO);
    void updateOrderStatus(long id, OrderDTO orderDTO);
}
