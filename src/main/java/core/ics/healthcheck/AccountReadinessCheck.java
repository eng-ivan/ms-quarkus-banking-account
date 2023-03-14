package core.ics.healthcheck;

import core.ics.service.AccountService;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.inject.Inject;

@Readiness
public class AccountReadinessCheck implements HealthCheck {

    @Inject
    AccountService accountService;

    @Override
    public HealthCheckResponse call() {

        if (accountService.list() == null){
            return HealthCheckResponse.down("Readiness I'm not Ready!");
        }else {
            return HealthCheckResponse.up("Readiness I'm Ready!");
        }
    }
}
