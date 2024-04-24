package one.team.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "user-service")
public interface UserServiceClient {

    @GetMapping("/users/{userId}/isAuthenticated")
    boolean isAuthenticated(@PathVariable Long userId);
}
