package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    private static final User user1 = new User("Masha", "Ivanova", (byte) 13);
    private static final User user2 = new User("Pasha", "Sidorov", (byte) 3);
    private static final User user3 = new User("Misha", "Reshetov", (byte) 21);
    private static final User user4 = new User("Dasha", "Kish", (byte) 55);

    public static void main(String[] args) {
        Util.getConnect();

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        List<User> users = userService.getAllUsers();
            for (User user : users) {
                System.out.println("User с именем — " + user.getName() + " добавлен в базу данных");
            }
            userService.removeUserById(1);
            userService.getAllUsers();
            userService.cleanUsersTable();
            userService.dropUsersTable();
            // реализуйте алгоритм здесь
    }
}
