package one.team.client;

import one.team.dto.response.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name = "business-logic", url = "http://business-logic:9090")
@FeignClient(name = "business-logic", url = "http://localhost:9090")
public interface ApiClient {

  @RequestMapping(method = RequestMethod.GET, value = "/courses/{id}")
  CourseDto getCoursesById(@PathVariable Long id);

}
