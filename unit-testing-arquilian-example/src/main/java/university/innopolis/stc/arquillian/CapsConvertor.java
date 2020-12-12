package university.innopolis.stc.arquillian;

import javax.ejb.Stateless;

@Stateless
public class CapsConvertor {

    public LowerCaseConverter getLowerCase() {
        return new LowerCaseConverter();
    }
}
