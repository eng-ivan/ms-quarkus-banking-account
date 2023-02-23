package core.ics.service;

import core.ics.model.Account;
import core.ics.repository.AccountRepository;
import core.ics.utils.ValidationParameter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AccountService {

    @Inject
    AccountRepository accountRepository;

    public List<Account> list(){
        return accountRepository
                .listAll()
                .stream()
                .collect(Collectors.toList());
    }

    public Account findByID(String id){
        Long index = ValidationParameter.validate(id);
        return accountRepository.findById(index);
    }
}
