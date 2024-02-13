package ru.otus.view;

import ru.otus.controller.UserController;
import ru.otus.model.User;
import ru.otus.util.Commands;

import java.util.Scanner;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com;

        while (true) {
            String command = prompt("Введите команду: ");
            try {
                com = Commands.valueOf(command);
                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE: {
                        String firstName = prompt("Имя: ");
                        String lastName = prompt("Фамилия: ");
                        String phone = prompt("Номер телефона: ");
                        User user = new User(firstName, lastName, phone);
                        userController.saveUser(user);
                        break;
                    }
                    case READ: {
                        String id = prompt("Идентификатор пользователя: ");
                        try {
                            User user = userController.readUser(Long.parseLong(id));
                            System.out.println(user);
                            System.out.println();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }
                    case LIST: {
                        System.out.println(userController.readAll());
                        break;
                    }
                    case UPDATE: {
                        String userId = prompt("Введите id пользователя: ");
                        String firstName = prompt("Имя: ");
                        String lastName = prompt("Фамилия: ");
                        String phone = prompt("Номер телефона: ");
                        User user = new User(firstName, lastName, phone);
                        userController.updateUser(userId, user);
                        break;
                    }
                    case DELETE: {
                        Long userId = Long.parseLong(prompt("Введите id пользователя: "));
                        boolean deleted = userController.deleteUser(userId);
                        if (deleted) {
                            System.out.printf("Пользователь с id: %d удален%n", userId);
                        } else {
                            System.out.printf("Пользователь с id: %d не найден%n", userId);
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.printf("Некорректная комманда: %s%n", command);
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
