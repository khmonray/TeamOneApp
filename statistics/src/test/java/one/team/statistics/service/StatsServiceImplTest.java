package one.team.statistics.service;

import com.google.gson.JsonObject;
import one.team.error.NotFoundException;
import one.team.client.ApiClient;
import one.team.dto.request.NewStatDto;
import one.team.dto.response.CourseDto;
import one.team.dto.response.StatDto;
import one.team.mapper.StatsMapper;
import one.team.model.Stat;
import one.team.repository.StatsRepository;
import one.team.service.StatsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class StatsServiceImplTest {

    @InjectMocks
    private StatsServiceImpl statsService;

    @Mock
    private StatsRepository mockStatsRepository;

    @Mock
    private ApiClient mockClient;

    @Mock
    private StatsMapper mockStatsMapper;

    final CourseDto courseDto = CourseDto.builder()
        .id(1L)
        .name("java")
        .price(100000)
        .build();

    final Stat stat = Stat.builder()
        .id(1L)
        .courseId(1L)
        .count(2)
        .build();

    final StatDto statDto = StatDto.builder()
        .courseDto(courseDto)
        .count(2)
        .build();

    final NewStatDto newStatDto = NewStatDto.builder()
        .courseId(1L)
        .build();

    final JsonObject innerObject = new JsonObject();


    @Test
    void addStat_whenAddStatForJavaCourse_thenStatAdded() {
//        innerObject.addProperty("id", 2);
//        innerObject.addProperty("name", "java");
//        innerObject.addProperty("price", 100000);
//
//        when(mockStatsMapper.toStatDto(stat)).thenReturn(statDto);
//        when(mockStatsRepository.save(any())).thenReturn(stat);
//        when(mockClient.getCoursesById(any())).thenReturn(String.valueOf(innerObject));
//
//        statsService.createStat(newStatDto);
//
//        verify(mockStatsRepository, times(1)).save(any());
    }

    @Test
    void addStat_whenJavaCourseNotFound_thenNotFoundExceptionThrown() {
        long courseNotFoundId = 0L;
        String error = String.format("course with id=%d is not found", courseNotFoundId);
        when(mockClient.getCoursesById(courseNotFoundId)).thenThrow(new NotFoundException(error));

        final NewStatDto newStatDto = NewStatDto.builder()
            .courseId(courseNotFoundId)
            .build();

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> statsService.createStat(newStatDto)
        );

        assertEquals(error, exception.getMessage());
        verify(mockStatsRepository, times(0)).save(any());
    }

    @Test
    void getStat_whenStatForJavaCourse_thenStatFound() {
//        innerObject.addProperty("id", 2);
//        innerObject.addProperty("name", "java");
//        innerObject.addProperty("price", 100000);
//
//        when(mockStatsMapper.toStatDto(List.of(stat))).thenReturn(List.of(statDto));
//        when(mockClient.getCoursesById(any())).thenReturn(String.valueOf(innerObject));
//        when(mockStatsRepository.findAll(any(Sort.class))).thenReturn(List.of(stat));
//
//        List<StatDto> actual = statsService.getStats();
//
//        assertEquals(List.of(statDto), actual);
    }

}
