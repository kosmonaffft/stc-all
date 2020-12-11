package university.innopolis.stc.powermock.badcode;

public class StaticInitializer {

    private static String filename;

    static {
        filename = "/home/anton";
    }

    public static String getFilename() {
        return filename;
    }
}
