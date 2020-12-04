package university.innopolis.stc.streams;

import java.util.function.Consumer;

public class FileStorage {

    public void getFile(Integer fileId, Consumer<String> fileAction) {
        // Получаем файл из хранилища...
        String file = "asdf";
        fileAction.accept(file);
    }
}
