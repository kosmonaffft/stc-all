package university.innopolis.stc.arquillian;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CapsService {

    @Inject
    private CapsConvertor capsConvertor;

    public String getConvertedCaps(String word) {
        return capsConvertor.getLowerCase().convert(word);
    }
}
