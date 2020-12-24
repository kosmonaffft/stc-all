package university.innopolis.stc.forum.app;

import org.flywaydb.core.Flyway;

public class Main {

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource(
                        "jdbc:postgresql://localhost:5432/forum1",
                        "postgres",
                        "postgres"
                )
                .load();
        flyway.migrate();
    }
}
