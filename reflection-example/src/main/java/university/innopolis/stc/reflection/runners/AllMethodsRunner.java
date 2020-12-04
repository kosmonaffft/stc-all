package university.innopolis.stc.reflection.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AllMethodsRunner implements ReflectionMethodsRunner {

    @Override
    public void runMethods(Object obj) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        Arrays.sort(methods, (o1, o2) -> o2.getName().compareTo(o1.getName()));

        for (Method method : methods) {
            if (method.getParameterCount() == 0) {
                Object result = method.invoke(obj);
                System.out.println(result);
            }
        }
    }
}
