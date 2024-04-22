package one.team.dto.response;

import lombok.Builder;

@Builder
public record StatDto(
    CourseDto courseDto,
    int count
) {

}
