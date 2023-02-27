package core.ics;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.HashMap;
import java.util.Map;


public class InitializerTestContainers implements QuarkusTestResourceLifecycleManager {

    private PostgreSQLContainer postgreSQLContainer;

    private Map<String, String> config(){
        final Map<String, String> config = new HashMap<>();
        config.put("quarkus.datasource.jdbc.url",postgreSQLContainer.getJdbcUrl());
        config.put("quarkus.datasource.username",postgreSQLContainer.getUsername());
        config.put("quarkus.datasource.password",postgreSQLContainer.getPassword());

        return config;
    }

    @Override
    public Map<String, String> start() {
        this.postgreSQLContainer = new PostgreSQLContainer<>("postgres:11");
        this.postgreSQLContainer.start();
        return config();
    }

    @Override
    public void stop() {
        if (postgreSQLContainer != null){
            postgreSQLContainer.close();
        }
    }
}
