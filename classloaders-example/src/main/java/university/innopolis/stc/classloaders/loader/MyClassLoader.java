package university.innopolis.stc.classloaders.loader;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    public static final String GOOD_MAGIC = "university.innopolis.stc.classloaders.magic.GoodMagic";

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (GOOD_MAGIC.equals(name)) {
            return findClass(name);
        }

        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass starts work: " + name);
        if (GOOD_MAGIC.equals(name)) {
            try (InputStream stream = getClass().getClassLoader()
                    .getResourceAsStream(
                            "university/innopolis/stc/classloaders/magic/GoodMagic.class")) {
                byte[] bytes = IOUtils.toByteArray(stream);
                return defineClass(name, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return super.findClass(name);
    }
}
