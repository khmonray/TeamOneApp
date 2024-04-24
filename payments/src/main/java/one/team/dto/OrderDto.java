package one.team.dto;


public record OrderDto(
                       Long courseId,
                       boolean isPaid,
                       Long userId) {
}
