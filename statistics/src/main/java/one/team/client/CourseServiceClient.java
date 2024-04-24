package one.team.client;

import one.team.dto.response.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name = "business-logic3", url = "http://business-logic:9093")
@FeignClient(name = "business-logic3", url = "http://localhost:9093")
public interface CourseServiceClient {

  @RequestMapping(method = RequestMethod.GET, value = "/courses/{id}")
  CourseDto getCoursesById(@PathVariable Long id);

}
