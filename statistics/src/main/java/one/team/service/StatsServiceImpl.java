package one.team.service;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.team.error.NotFoundException;
import one.team.client.CourseServiceClient;
import one.team.dto.request.NewStatDto;
import one.team.dto.response.CourseDto;
import one.team.dto.response.StatDto;
import one.team.mapper.StatsMapper;
import one.team.model.Stat;
import one.team.repository.StatsRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final StatsRepository statsRepository;

    private final StatsMapper statsMapper;

    private final CourseServiceClient client;

    @Transactional
    @Override
    public void createStat(NewStatDto newStatDto) {
        try {
            client.getCoursesById(newStatDto.courseId());
        } catch (NullPointerException e) {
            throw new NotFoundException(String.format("course with id=%d is not found", newStatDto.courseId()));
        }
        Stat stat = statsRepository.findByCourseId(newStatDto.courseId());
        int count;
        try {
            count = stat.getCount();
        } catch (NullPointerException e) {
            count = 0;
            stat = new Stat();
            stat.setCourseId(newStatDto.courseId());
        }
        count++;
        stat.setCount(count);

        statsRepository.save(stat);
    }

    @Transactional(readOnly = true)
    @Override
    public List<StatDto> getStats() {
        List<Stat> statEntities = statsRepository.findAll(Sort.by(Sort.Order.desc("count")));
        for (Stat stat : statEntities) {
            CourseDto courseDto = client.getCoursesById(stat.getCourseId());
            stat.setCourseDto(courseDto);
        }
        List<StatDto> statDtoList = statsMapper.toStatDto(statEntities);
        return statDtoList;
    }

}
