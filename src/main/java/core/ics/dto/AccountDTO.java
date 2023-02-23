package core.ics.dto;

import core.ics.model.Account;
import core.ics.model.Agency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AccountDTO implements Serializable {

    Long id;
    String agency;
    String account;
    LocalDateTime createAt;

    public AccountDTO(Account account){
        this.agency = account.getAgency();
        this.account = account.getAccount();
    }
}
