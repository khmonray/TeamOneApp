package one.team.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderDto(@JsonProperty("course_name") String courseName,
                       @JsonProperty("is_paid") boolean isPaid,
                       @JsonProperty("user_id") Long userId) {
}
