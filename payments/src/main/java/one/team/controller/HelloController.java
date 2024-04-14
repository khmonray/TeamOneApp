package one.team.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import one.team.dto.OrderDto;
import one.team.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payments")
@NoArgsConstructor
@AllArgsConstructor
public class HelloController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/process")
    public void processPayment(@RequestBody OrderDto orderDto) {
        paymentService.processPayment(orderDto);
    }

    @GetMapping("/confirm/{uuid}")
    public String confirmPayment(@PathVariable("uuid") UUID uuid) {
        paymentService.confirmPayment(uuid);
        return "Payment confirmed";
    }
}
