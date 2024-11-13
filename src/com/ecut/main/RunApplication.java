package com.ecut.main;

import com.ecut.service.StudentService;

import java.sql.SQLException;
import java.util.Scanner;

public class RunApplication {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        init();
    }

    public static void init() throws SQLException {
        System.out.println("-------------Welcome to Student Management System !----------------");
        System.out.println("1,select\n2,update\n3,delete\n4,insert\n5,exit");

        functionService();
    }

    public static void functionService() throws SQLException {

        switch (scanner.nextLine()) {
            case "1":
                System.out.println(StudentService.SelectAll());
                break;
            case "2":
                StudentService.update(scanner.nextInt(), scanner.next(), scanner.next());
                break;
            case "3":
                StudentService.delete(scanner.nextInt());
                break;
            case "4":
                StudentService.insert(scanner.next(),scanner.next());
                break;
            case "5": System.exit(0); break;
            default: break;
        }
    }
}
