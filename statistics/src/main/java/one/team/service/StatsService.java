package one.team.service;

import java.util.List;
import one.team.dto.request.NewStatDto;
import one.team.dto.response.StatDto;

public interface StatsService {

    void createStat(NewStatDto newStatDto);

    List<StatDto> getStats();

}
