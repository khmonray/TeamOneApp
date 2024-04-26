package one.team.mapper;

import one.team.dto.AccountDTO;
import one.team.model.Account;

public class MapperAccount implements Mapper<AccountDTO, Account> {

    @Override
    public AccountDTO daoToDto(Account account) {
        return new AccountDTO(account.getId(), account.getEmail(), account.getPassword());

    }

    @Override
    public Account dtoToDao(AccountDTO accountDTO) {
        return new Account(accountDTO.id(), accountDTO.email(), accountDTO.password());
    }
}
