package university.innopolis.stc.reflection.runners;

import java.lang.reflect.InvocationTargetException;

public interface ReflectionMethodsRunner {

    void runMethods(Object obj) throws InvocationTargetException, IllegalAccessException;
}
