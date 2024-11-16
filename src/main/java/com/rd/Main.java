package com.rd;

import com.rd.config.HibernateConfig;
import com.rd.controller.UserController;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();

        // Kullanıcı oluşturma
        userController.createUser("john_doe", "john@example.com");
        userController.createUser("jane_doe", "jane@example.com");

        // Tüm kullanıcıları listeleme
        userController.listUsers();

        // Hibernate oturumunu kapatma
        HibernateConfig.closeSessionFactory();
    }
}

