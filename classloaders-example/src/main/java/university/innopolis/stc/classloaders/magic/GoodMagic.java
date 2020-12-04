package university.innopolis.stc.classloaders.magic;

public class GoodMagic implements Magic {

    static {
        System.out.println("Хоттабыч инициализируется...");
    }

    @Override
    public void doMagic() {
        System.out.println("Абра-кадабра!!!");
    }
}
