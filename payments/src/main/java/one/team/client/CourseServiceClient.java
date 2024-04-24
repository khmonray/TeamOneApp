package one.team.client;


import one.team.dto.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "business-logic2", url = "http://business-logic:9093")
@FeignClient(name = "business-logic2", url = "http://localhost:9093/courses")
public interface CourseServiceClient {

  @GetMapping(value = "{id}}")
  CourseDto getCoursesById(@PathVariable("id") String id);

}
