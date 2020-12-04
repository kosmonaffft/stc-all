package university.innopolis.stc.reflection.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotatedMethodsRunner implements ReflectionMethodsRunner {

    private final Class<? extends Annotation> annotation;

    public AnnotatedMethodsRunner(Class<? extends Annotation> annotation) {
        this.annotation = annotation;
    }

    @Override
    public void runMethods(Object obj) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getParameterCount() == 0 && method.getAnnotation(annotation) != null) {
                Object result = method.invoke(obj);
                System.out.println(result);
            }
        }
    }
}
