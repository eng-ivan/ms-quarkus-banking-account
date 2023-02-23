package core.ics.service;

import core.ics.model.Agency;

import javax.enterprise.context.ApplicationScoped;
import java.security.SecureRandom;
import java.util.Random;

@ApplicationScoped
public class AgencyService {

    public Agency generateAgency(){
        Integer[] agency_number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Agency ag = new Agency();

        Random random = new SecureRandom();

        int d1 = random.nextInt(10);
        int d2 = random.nextInt(10);
        int d3 = random.nextInt(10);

        return Agency
                .builder()
                .agency(agency_number[d1].toString()+agency_number[d2].toString()+agency_number[d3].toString())
                .build();
    }
}
