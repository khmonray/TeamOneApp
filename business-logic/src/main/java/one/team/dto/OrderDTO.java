package one.team.dto;

public record OrderDTO(Long id, Long userId, Long courseId, String courseName, boolean isPaid) {

}
