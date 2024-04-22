package one.team.dto.response;

import lombok.Builder;

@Builder
public record CourseDto(
    long id,
    String name,
    int price
) {

}
