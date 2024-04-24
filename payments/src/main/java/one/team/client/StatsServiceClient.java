package one.team.client;

import one.team.dto.StatisticDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "statistics", url = "http://localhost:9091")
//@FeignClient(name = "statistics", url = "http://statistics:9091")
public interface StatsServiceClient {

  @PostMapping("/stats")
  void sendStats(@RequestBody StatisticDto statisticDto);
}
