package one.team.mapper;

import java.util.List;
import one.team.dto.CourseDto;
import one.team.dto.NewCourseDto;
import one.team.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

  CourseDto toCourseDto(Course course);

  List<CourseDto> toCourseDto(List<Course> courses);

  Course toCourse(NewCourseDto newCourseDto);

}