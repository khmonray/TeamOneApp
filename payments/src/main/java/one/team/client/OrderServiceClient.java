package one.team.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "business-logic", url = "http://localhost:9093/order")
//@FeignClient(name = "business-logic", url = "http://business-logic:9093/order")
public interface OrderServiceClient {

    @PutMapping("{id}")
    void updateOrder(@PathVariable("id") Long id);
}
