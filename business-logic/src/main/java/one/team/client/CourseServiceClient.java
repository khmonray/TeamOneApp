package one.team.client;


import one.team.dto.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "business-logic", url = "http://business-logic:9093")
@FeignClient(name = "business-logic", url = "http://localhost:9093")
public interface CourseServiceClient {

  @GetMapping(value = "/courses/{id}")
  CourseDto getCoursesById(@PathVariable("id") Long orderId);

}
