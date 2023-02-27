package core.ics.service;

import core.ics.model.Account;
import core.ics.repository.AccountRepository;
import core.ics.utils.ValidationParameter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class AccountService {

    @Inject
    AccountRepository accountRepository;

    @Inject
    AgencyService agencyService;

    public Account save(){

        Integer[] account_digit = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Random random = new Random();
        Account accountNumber = new Account();
        int random_digit = random.nextInt(10);

        accountNumber.setAccount("00"+agencyService.generateAgency().getAgency());

        Account account = Account
                .builder()
                .account(agencyService.generateAgency().getAgency() + accountNumber.getAccount() + "-" + account_digit[random_digit])
                .agency(agencyService.generateAgency().getAgency())
                .build();

        accountRepository.persist(account);

        return account;
    }

    public List<Account> list(){
        return accountRepository.listAll();
    }

    public Account findByID(String value){
        Long id = ValidationParameter.validate(value);
        return accountRepository.findById(id);
    }
}
