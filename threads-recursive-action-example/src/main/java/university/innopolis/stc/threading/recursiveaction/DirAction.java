package university.innopolis.stc.threading.recursiveaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;

public class DirAction extends RecursiveAction {

    private String dir;

    private ArrayList<String> result = new ArrayList<>();

    public DirAction(String dir) {
        this.dir = dir;
    }

    @Override
    protected void compute() {
        String name = Thread.currentThread().getName();
        System.out.println(String.format("Processing dir %s from thread %s", dir, name));
        try {
            Path path = Paths.get(dir);
            if (Files.isDirectory(path)) {
                List<Path> innerFiles = Files.list(path).collect(Collectors.toList());
                List<DirAction> tasks = new ArrayList<>();
                for (Path innerFile : innerFiles) {
                    DirAction task = new DirAction(innerFile.toString());
                    tasks.add(task);
                }

                List<List<String>> collect = new ArrayList<>();
                Collection<DirAction> dirTasks = ForkJoinTask.invokeAll(tasks);
                for (DirAction t : dirTasks) {
                    t.join();
                    collect.add(t.result);
                }

                for (List<String> strings : collect) {
                    result.addAll(strings);
                }
            } else {
                result.add(dir);
            }
        } catch (IOException e) {
        }
    }

    public ArrayList<String> getResult() {
        return result;
    }
}
