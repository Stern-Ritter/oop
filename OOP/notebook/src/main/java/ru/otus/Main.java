package ru.otus;

import ru.otus.oop.controller.UserController;
import ru.otus.oop.util.helper.impl.BaseFileHelper;
import ru.otus.oop.model.repository.Repository;
import ru.otus.oop.model.repository.impl.UserRepository;
import ru.otus.oop.view.UserView;

import java.io.IOException;

import static ru.otus.oop.util.DBConnector.DB_PATH;
import static ru.otus.oop.util.DBConnector.createDB;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        createDB();
        BaseFileHelper fileOperation;
        try {
            fileOperation = new BaseFileHelper(DB_PATH);
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("Некорректный путь к файлу с данными: %s", DB_PATH));
        }
        Repository repository = new UserRepository(fileOperation);
        UserController controller = new UserController(repository);
        UserView view = new UserView(controller);
        view.run();
    }
}
