package university.innopolis.stc.forum.app;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

public abstract class BaseTest {

    protected static EmbeddedPostgres embeddedPostgres;

    @BeforeAll
    protected static void init() throws IOException {
        embeddedPostgres = EmbeddedPostgres.builder().start();
        Flyway flyway = Flyway.configure()
                .dataSource(embeddedPostgres.getPostgresDatabase()).load();
        flyway.migrate();
    }

    @AfterAll
    protected static void deInit() throws IOException {
        embeddedPostgres.close();
    }
}
