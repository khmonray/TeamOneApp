package one.team.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.team.dto.request.NewStatDto;
import one.team.dto.response.StatDto;
import one.team.service.StatsService;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class StatsController {

  private final StatsService statsService;

  @PostMapping("/stats")
  @ResponseStatus(value = HttpStatus.CREATED)
  public void createStats(@RequestBody NewStatDto newStatDto) throws NotFoundException {
    log.info("Получен POST-запрос к эндпоинту: '/stats'");
    statsService.createStat(newStatDto);
  }

  @GetMapping("/stats")
  public ResponseEntity<List<StatDto>> getStats() {
    log.info("Получен GET-запрос к эндпоинту: '/stats'");
    return ResponseEntity.ok(statsService.getStats());
  }

}
