package university.innopolis.stc.refactoring.entity;

import university.innopolis.stc.refactoring.db.DbConnection;

public class User {

    public static User find(Long id, String login) {
        return DbConnection.getInstance().getUser(id);
    }

    private Long id;

    private String login;

    private String encodedPassword;

    public void save() {
        DbConnection.getInstance().saveUser(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }
}
