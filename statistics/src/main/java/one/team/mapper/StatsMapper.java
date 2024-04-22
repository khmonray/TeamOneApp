package one.team.mapper;

import java.util.List;
import one.team.dto.response.StatDto;
import one.team.model.Stat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatsMapper {

  StatDto toStatDto(Stat stat);

  List<StatDto> toStatDto(List<Stat> stats);

}