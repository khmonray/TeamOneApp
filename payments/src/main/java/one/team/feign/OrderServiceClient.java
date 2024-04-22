package one.team.feign;

import one.team.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "business-logic", url = "http://localhost:8081")
public interface OrderServiceClient {

    @PostMapping("/business-logic/orders")
    void sendOrder(@RequestBody OrderDto orderDto);
}

