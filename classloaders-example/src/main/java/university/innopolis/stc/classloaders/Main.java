package university.innopolis.stc.classloaders;

import university.innopolis.stc.classloaders.loader.MyClassLoader;
import university.innopolis.stc.classloaders.magic.BadMagic;
import university.innopolis.stc.classloaders.magic.GoodMagic;
import university.innopolis.stc.classloaders.magic.Magic;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        System.out.println("Сейчас будет магия");
        Magic magic = new BadMagic();
        magic.doMagic();

        ClassLoader myClassLoader = new MyClassLoader();
        Class<?> goodClass = myClassLoader.loadClass(MyClassLoader.GOOD_MAGIC);

        Magic goodMagic = (Magic) goodClass.getDeclaredConstructor().newInstance();
        goodMagic.doMagic();

        GoodMagic km1 = new GoodMagic();
        GoodMagic km2 = (GoodMagic) goodMagic;

        System.out.println("Всё, конец");
    }
}
