package ru.otus;

import ru.otus.controller.UserController;
import ru.otus.model.dao.impl.FileOperation;
import ru.otus.model.repository.GBRepository;
import ru.otus.model.repository.impl.UserRepository;
import ru.otus.view.UserView;

import static ru.otus.util.DBConnector.DB_PATH;
import static ru.otus.util.DBConnector.createDB;

public class Main {
    public static void main(String[] args) {
        createDB();
        FileOperation fileOperation = new FileOperation(DB_PATH);
        GBRepository repository = new UserRepository(fileOperation);
        UserController controller = new UserController(repository);
        UserView view = new UserView(controller);
        view.run();
    }
}
