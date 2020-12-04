package university.innopolis.stc.classloaders.magic;

public class BadMagic implements Magic {

    static {
        System.out.println("Злой волшебник идет...");
    }

    @Override
    public void doMagic() {
        System.out.println("Ахалай-Махалай!!!");
    }
}
