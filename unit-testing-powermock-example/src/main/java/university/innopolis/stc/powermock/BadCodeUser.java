package university.innopolis.stc.powermock;

import university.innopolis.stc.powermock.badcode.StaticInitializer;

public class BadCodeUser {

    public String process(String parameter) {
        return StaticInitializer.getConnection().toString() + ":" + parameter;
    }
}
