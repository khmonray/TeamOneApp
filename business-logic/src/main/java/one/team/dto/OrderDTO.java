package one.team.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class OrderDTO {

    private Long orderId;
    private Long userId;
    private Long courseId;
    private boolean isPaid;

}
