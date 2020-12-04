package university.innopolis.stc.streams;

public class SecurityLogger {

    void doWithExceptionHandler(Runnable runnable) {
        try {
            runnable.run();
            System.out.println("Все хорошо...");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так!!!");
            e.printStackTrace();
        }
    }
}
