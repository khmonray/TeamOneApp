package one.team.repository;

import one.team.model.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<Stat, Long> {

  Stat findByCourseId(Long courseId);

}
