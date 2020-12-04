package university.innopolis.stc.threading.recursivetask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {

    static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static ForkJoinPool forkJoinPool = new ForkJoinPool(4);

    public static List<String> getFiles(String dir) throws IOException, InterruptedException {
        Thread.sleep(10 * 1000);
        return Files.list(Paths.get(dir))
                .map(Path::toString)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        DirTask t = new DirTask(".");
        List<String> invoke = forkJoinPool.invoke(t);
        for (String s : invoke) {
            System.out.println(s);
        }
    }
}
