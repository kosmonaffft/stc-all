package university.innopolis.stc.logging;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.logging.Logger;

import static java.text.MessageFormat.format;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    private final static Logger log = Logger.getLogger(User.class.getCanonicalName());

    @NonNull
    private final String login;

    private String password;

    public void closeUser() throws Exception {
        log.severe(format("User {0} are closed...", this));
    }
}
