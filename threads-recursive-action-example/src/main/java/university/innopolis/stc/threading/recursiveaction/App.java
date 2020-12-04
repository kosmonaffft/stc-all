package university.innopolis.stc.threading.recursiveaction;

import java.util.concurrent.ForkJoinPool;

/**
 * Hello world!
 */
public class App {

    public static ForkJoinPool forkJoinPool = new ForkJoinPool(3);

    public static void main(String[] args) {

        DirAction t = new DirAction(".");
        forkJoinPool.invoke(t);
        for (String s : t.getResult()) {
            System.out.println(s);
        }
    }
}
