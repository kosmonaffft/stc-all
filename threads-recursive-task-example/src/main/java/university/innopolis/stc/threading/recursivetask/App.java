package university.innopolis.stc.threading.recursivetask;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * Hello world!
 */
public class App {

    public static ForkJoinPool forkJoinPool = new ForkJoinPool(4);

    public static void main(String[] args) {
        DirTask t = new DirTask(".");
        List<String> invoke = forkJoinPool.invoke(t);
        for (String s : invoke) {
            System.out.println(s);
        }
    }
}
