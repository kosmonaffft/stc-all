package test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 */
public class App {

    static List<ReentrantLock> forks = new ArrayList<ReentrantLock>() {{
        add(new ReentrantLock());
        add(new ReentrantLock());
        add(new ReentrantLock());
        add(new ReentrantLock());
        add(new ReentrantLock());
    }};

    static public void philosopher(int number) {
        int leftFork = number;
        int rightFork = (number + 1) % 5;
        while (1 == 1) {
            boolean toDo = (Math.random() > 0.999 ? true : false);
            if (toDo) {
                System.out.println(String.format("Philosopher %s begins to think", number));
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(String.format("Philosopher %s ends to think", number));
            } else {
                System.out.println(String.format("Philosopher %s wants to take %s fork", number, number % 2 == 0 ? "left" : "right"));
                forks.get(number % 2 == 0 ? leftFork : rightFork).lock();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(String.format("Philosopher %s wants to take %s fork", number, number % 2 != 0 ? "left" : "right"));
                forks.get(number % 2 != 0 ? leftFork : rightFork).lock();
                System.out.println(String.format("Philosopher %s begins to eat", number));
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(String.format("Philosopher %s ends to eat", number));
            }
            forks.get(leftFork).unlock();
            System.out.println(String.format("Philosopher %s puts right fork", number));
            forks.get(rightFork).unlock();
            System.out.println(String.format("Philosopher %s puts left fork", number));
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, IOException, InterruptedException {
        List<Thread> threadList = new ArrayList<Thread>() {{
            add(new Thread(() -> philosopher(0)));
            add(new Thread(() -> philosopher(1)));
            add(new Thread(() -> philosopher(2)));
            add(new Thread(() -> philosopher(3)));
            add(new Thread(() -> philosopher(4)));
        }};

        threadList.forEach(t -> t.start());
    }
}
