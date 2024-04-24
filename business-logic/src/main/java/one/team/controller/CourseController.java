package one.team.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.team.dto.CourseDto;
import one.team.dto.NewCourseDto;
import one.team.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CourseController {

  private final CourseService service;

  @PostMapping("/courses")
  @ResponseStatus(value = HttpStatus.CREATED)
  public String createCourse(@RequestBody NewCourseDto newCourseDto) {
    log.info("Получен POST-запрос к эндпоинту: '/courses'");
    service.createCourse(newCourseDto);
    return "Course created";
  }

  @GetMapping("/courses")
  public ResponseEntity<List<CourseDto>> getAllCourses() {
    log.info("Получен GET-запрос к эндпоинту: '/courses'");
    return ResponseEntity.ok(service.getAllCourses());
  }

  @GetMapping("/courses/{id}")
  public ResponseEntity<CourseDto> getCourseById(@PathVariable Long id) {
    log.info("Получен GET-запрос к эндпоинту: '/courses/{id}'");
    return ResponseEntity.ok(service.getCourseById(id));
  }

}
