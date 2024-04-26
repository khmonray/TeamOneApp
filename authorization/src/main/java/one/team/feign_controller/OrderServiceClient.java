package one.team.feign_controller;

import one.team.dto.OrderDTO;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/*
@FeignClient(name = "business-logic", url = "http://localhost:9093/order")
public interface OrderServiceClient {
    @PostMapping("/order")
    void createOrder(@RequestBody OrderDTO orderDTO);

    @PutMapping("/order/{id}")
    void updateOrderStatus(@PathVariable("id") long id, @RequestBody OrderDTO orderDTO);
}

*/
