package one.team.repo;

import one.team.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
     Account findAccountByEmail(String mail);

}
