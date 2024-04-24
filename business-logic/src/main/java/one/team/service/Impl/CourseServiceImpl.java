package one.team.service.Impl;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import one.team.error.NotFoundException;
import one.team.dto.CourseDto;
import one.team.dto.NewCourseDto;
import one.team.entity.Course;
import one.team.mapper.CourseMapper;
import one.team.repository.CourseRepository;
import one.team.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    private final CourseMapper mapper;

    @Transactional
    @Override
    public void createCourse(NewCourseDto newCourseDto) {
        Course course = mapper.toCourse(newCourseDto);
        repository.save(course);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = repository.findAll();
        return mapper.toCourseDto(courses);
    }

    @Transactional(readOnly = true)
    @Override
    public CourseDto getCourseById(Long id) {
        Course course = repository.findById(id).orElseThrow(() ->
            new NotFoundException(String.format("course with id=%d is not found", id)));
        return mapper.toCourseDto(course);
    }
}
