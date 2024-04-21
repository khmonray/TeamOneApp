package one.team.controller;

import one.team.dto.OrderDTO;
import one.team.service.Impl.OrderServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public void createOrder(@RequestBody OrderDTO orderDTO) {
        orderService.createOrder(orderDTO);
    }

    @PutMapping("/{id}")
    public void updateOrderStatus(@RequestParam long id,
                                  @RequestBody OrderDTO orderDTO){
        orderService.updateOrderStatus(id, orderDTO);
    }

}
