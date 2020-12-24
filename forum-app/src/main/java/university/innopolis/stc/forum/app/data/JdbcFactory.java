package university.innopolis.stc.forum.app.data;

import javax.sql.DataSource;

public class JdbcFactory {

    private final DataSource dataSource;

    public JdbcFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Jdbc getJdbc() {
        throw new RuntimeException();
    }
}
