package one.team.controller;

import one.team.dto.AnswerOrderDto;
import one.team.dto.NewOrderDTO;
import one.team.dto.OrderDTO;
import one.team.service.Impl.OrderServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public NewOrderDTO createOrder(@RequestBody NewOrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @GetMapping("/{id}")
    public AnswerOrderDto getOrderById(@PathVariable String id) {
        return orderService.getOrder(Long.parseLong(id));
    }

    @PutMapping("/{id}")
    public void updateOrderStatus(@PathVariable("id") Long id){
        orderService.updateOrderStatus(id);
    }

}
