package one.team.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class NewOrderDTO {
    private Long orderId;
    private Long userId;
    private Long courseId;
    private String link;

}
