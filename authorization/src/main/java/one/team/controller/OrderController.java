package one.team.controller;

import one.team.dto.OrderDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping()
    public void createOrder(@RequestBody OrderDTO orderDTO) {

    }

/*
    @PutMapping("/{id}")
    public void updateOrderStatus(@RequestParam long id,
                                  @RequestBody OrderDTO orderDTO) {

    }
*/

}
