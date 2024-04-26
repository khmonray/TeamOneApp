package one.team.controller;

import one.team.dto.AccountDTO;
import one.team.service.ServiceAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "accounts")
public class AccountController {

    private final ServiceAccount serviceAccount;

    public AccountController(@Autowired ServiceAccount serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getById(Long id) {
        return new ResponseEntity<>(serviceAccount.getById(id), HttpStatus.OK);
    }
}
