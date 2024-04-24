package one.team.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AnswerOrderDto {
      Long id;
      Long userId;
      CourseDto courseDto;
      boolean isPaid;
  }
