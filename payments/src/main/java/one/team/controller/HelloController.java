package one.team.controller;

import lombok.AllArgsConstructor;
import one.team.dto.OrderDto;
import one.team.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class HelloController {

    private final PaymentService paymentService;

    @PostMapping("/payment/process")
    public ResponseEntity<String>processPayment(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(paymentService.processPayment(orderDto));
    }

    @GetMapping("/confirm/{uuid}")
    public String confirmPayment(@PathVariable("uuid") UUID uuid) {
        paymentService.confirmPayment(uuid);
        return "Payment confirmed";
    }
}
