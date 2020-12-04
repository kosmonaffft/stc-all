package university.innopolis.stc.reflection;

import university.innopolis.stc.reflection.annotation.RunMe;
import university.innopolis.stc.reflection.methods.MethodsToRun;
import university.innopolis.stc.reflection.runners.AllMethodsRunner;
import university.innopolis.stc.reflection.runners.AnnotatedMethodsRunner;
import university.innopolis.stc.reflection.runners.ReflectionMethodsRunner;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

/**
 * Hello world!
 */
public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, IOException {
        MethodsToRun methodsToRun = new MethodsToRun();
        ReflectionMethodsRunner allRunner = new AllMethodsRunner();
        ReflectionMethodsRunner annotatedRunner = new AnnotatedMethodsRunner(Deprecated.class);

        System.out.println("Run all methods:");
        allRunner.runMethods(methodsToRun);

        System.out.println("Run annotated methods:");
        annotatedRunner.runMethods(methodsToRun);

        System.out.println("Resources file example:");
        try (InputStream stream = Main.class.getClassLoader().getResourceAsStream("hello.txt")) {
            new Scanner(Objects.requireNonNull(stream)).forEachRemaining(System.out::println);
        }

        System.out.println("Properties example:");
        Properties properties = new Properties();
        try (InputStream stream = Main.class.getClassLoader().getResourceAsStream("hello.properties")) {
            properties.load(stream);
        }

        System.out.println("myKey = " + properties.getProperty("myKey"));
        System.out.println("anotherKey = " + properties.getProperty("anotherKey"));
    }
}
