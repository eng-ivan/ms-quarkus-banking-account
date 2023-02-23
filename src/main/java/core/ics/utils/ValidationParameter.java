package core.ics.utils;

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
            return Long.parseLong(id);
        }catch (NumberFormatException e){
            log.error("Error: {}", e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
