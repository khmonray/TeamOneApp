package one.team.dto;

import lombok.Builder;

@Builder
public record NewCourseDto(
    String name,
    int price
) {

}