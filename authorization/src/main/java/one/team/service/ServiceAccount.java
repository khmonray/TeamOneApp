package one.team.service;


import one.team.dto.AccountDTO;
import one.team.mapper.Mapper;
import one.team.mapper.MapperAccount;
import one.team.model.Account;
import one.team.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceAccount {
    Mapper<AccountDTO, Account> mapper = new MapperAccount();

    private final AccountRepository repo;

    public ServiceAccount(@Autowired AccountRepository repo) {
        this.repo = repo;
    }

    public AccountDTO getById(Long id) {
        Optional<Account> account = repo.findById(id);
        return mapper.daoToDto(account.get());
    }

   /* public Account loadUserByUsername(String email) throws UsernameNotFoundException {
        Account user = RepositoryAccount.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Account not found with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }*/
}
