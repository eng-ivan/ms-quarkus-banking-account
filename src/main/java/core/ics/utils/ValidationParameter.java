package core.ics.utils;

import core.ics.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class ValidationParameter {

    private ValidationParameter(){}

    public static Long validate(String id){
        try {
            return Long.valueOf(id);
        }catch (NumberFormatException e){
            log.error("Error: {}", e.getMessage());
            throw new BusinessException(e.getMessage());
        }
    }
}
