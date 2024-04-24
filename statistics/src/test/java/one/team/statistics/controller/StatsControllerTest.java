package one.team.statistics.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.SneakyThrows;
import one.team.StatsServerApp;
import one.team.client.CourseServiceClient;
import one.team.controller.StatsController;
import one.team.dto.request.NewStatDto;
import one.team.dto.response.CourseDto;
import one.team.dto.response.StatDto;
import one.team.service.StatsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@ContextConfiguration(classes = StatsServerApp.class)
@WebMvcTest(controllers = StatsController.class)
class StatsControllerTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseServiceClient client;

    @MockBean
    private StatsService service;

    final NewStatDto newStatDto = NewStatDto.builder()
        .courseId(1L)
        .build();

    final CourseDto courseDto = CourseDto.builder()
        .id(1L)
        .name("java")
        .price(100000)
        .build();

    final StatDto statDto = StatDto.builder()
        .courseDto(courseDto)
        .count(2)
        .build();

    @Test
    @SneakyThrows
    void addStats() {
        when(client.getCoursesById(anyLong())).thenReturn(courseDto);
        doNothing().when(service).createStat(any(NewStatDto.class));

        mockMvc.perform(post("/stats")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(newStatDto)))
                .andExpect(status().isCreated());
    }

    @Test
    @SneakyThrows
    void getStats() {
        when(client.getCoursesById(anyLong())).thenReturn(courseDto);
        when(service.getStats()).thenReturn(List.of(statDto));

        mockMvc.perform(get("/stats")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
