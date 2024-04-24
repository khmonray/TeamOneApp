package one.team.dto;

import lombok.Builder;

@Builder
public record CourseDto(
    long id,
    String name,
    int price
) {

}
