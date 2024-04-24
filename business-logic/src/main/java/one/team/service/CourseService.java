package one.team.service;


import java.util.List;
import one.team.dto.CourseDto;
import one.team.dto.NewCourseDto;


public interface CourseService {

  void createCourse(NewCourseDto newCourseDto);

  List<CourseDto> getAllCourses();

  CourseDto getCourseById(Long id);
}
