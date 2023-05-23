package org.example;

import java.sql.*;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1 - создать БД\n2 - заполнить данными\n3 - вывести данные");
            int choise = scanner.nextInt();
            Statement statement = connection.createStatement();

            switch (choise) {
                case 1:
                    try {
                        String query = "CREATE TABLE Издания (\n" +
                                "  ИндексИздания INT PRIMARY KEY,\n" +
                                "  НазвИздания VARCHAR(255),\n" +
                                "  СтоимостьЗаГод DECIMAL(10, 2),\n" +
                                "  КодГруппыИзданий INT\n" +
                                ");\n" +
                                "\n" +
                                "\n" +
                                "CREATE TABLE Подписчики (\n" +
                                "  КодПодписчика INT PRIMARY KEY,\n" +
                                "  ФамилияПодписчика VARCHAR(255),\n" +
                                "  Адрес VARCHAR(255)\n" +
                                ");\n" +
                                "\n" +
                                "\n" +
                                "CREATE TABLE ГруппыИзданий (\n" +
                                "  КодГруппы INT PRIMARY KEY,\n" +
                                "  НаименованиеГруппыИзданий VARCHAR(255),\n" +
                                "  ПроцентСкидки DECIMAL(5, 2)\n" +
                                ");\n" +
                                "\n" +
                                "\n" +
                                "CREATE TABLE Подписка (\n" +
                                "  ГодПодписки INT,\n" +
                                "  ИндексИздания INT,\n" +
                                "  КодПодписчика INT,\n" +
                                "  СрокПодписки INT,\n" +
                                "  МестоДоставки VARCHAR(255),\n" +
                                "  PRIMARY KEY (ГодПодписки, ИндексИздания, КодПодписчика),\n" +
                                "  FOREIGN KEY (ИндексИздания) REFERENCES Издания(ИндексИздания),\n" +
                                "  FOREIGN KEY (КодПодписчика) REFERENCES Подписчики(КодПодписчика)\n" +
                                ");\n";
                        statement.execute(query);
                    } catch (Exception e) {
                        throw new Exception("Таблицы уже созданны.");
                    }
                    break;
                case 2:
                    try {
                        String query_ins = "INSERT INTO Издания (ИндексИздания, НазвИздания, СтоимостьЗаГод, КодГруппыИзданий)\n" +
                                "VALUES\n" +
                                "  (1, 'Издание 1', 100.00, 1),\n" +
                                "  (2, 'Издание 2', 150.00, 2),\n" +
                                "  (3, 'Издание 3', 80.00, 1),\n" +
                                "  (4, 'Издание 4', 120.00, 2),\n" +
                                "  (5, 'Издание 5', 90.00, 1),\n" +
                                "  (6, 'Издание 6', 200.00, 3),\n" +
                                "  (7, 'Издание 7', 110.00, 2),\n" +
                                "  (8, 'Издание 8', 70.00, 1),\n" +
                                "  (9, 'Издание 9', 130.00, 2),\n" +
                                "  (10, 'Издание 10', 95.00, 1);\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "INSERT INTO Подписчики (КодПодписчика, ФамилияПодписчика, Адрес)\n" +
                                "VALUES\n" +
                                "  (1, 'Иванов', 'Адрес 1'),\n" +
                                "  (2, 'Петров', 'Адрес 2'),\n" +
                                "  (3, 'Сидоров', 'Адрес 3'),\n" +
                                "  (4, 'Смирнов', 'Адрес 4'),\n" +
                                "  (5, 'Федоров', 'Адрес 5'),\n" +
                                "  (6, 'Соколов', 'Адрес 6'),\n" +
                                "  (7, 'Михайлов', 'Адрес 7'),\n" +
                                "  (8, 'Васильев', 'Адрес 8'),\n" +
                                "  (9, 'Павлов', 'Адрес 9'),\n" +
                                "  (10, 'Новиков', 'Адрес 10');\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "INSERT INTO ГруппыИзданий (КодГруппы, НаименованиеГруппыИзданий, ПроцентСкидки)\n" +
                                "VALUES\n" +
                                "  (1, 'Группа 1', 10.00),\n" +
                                "  (2, 'Группа 2', 15.00),\n" +
                                "  (3, 'Группа 3', 5.00),\n" +
                                "  (4, 'Группа 4', 12.50),\n" +
                                "  (5, 'Группа 5', 8.00),\n" +
                                "  (6, 'Группа 6', 18.00),\n" +
                                "  (7, 'Группа 7', 7.50),\n" +
                                "  (8, 'Группа 8', 9.00),\n" +
                                "  (9, 'Группа 9', 13.50),\n" +
                                "  (10, 'Группа 10', 11.00);\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "INSERT INTO Подписка (ГодПодписки, ИндексИздания, КодПодписчика, СрокПодписки, МестоДоставки)\n" +
                                "VALUES\n" +
                                "  (2022, 1, 1, 12, 'Адрес 1'),\n" +
                                "  (2022, 2, 2, 6, 'Адрес 2'),\n" +
                                "  (2022, 3, 3, 3, 'Адрес 3'),\n" +
                                "  (2022, 4, 4, 9, 'Адрес 4'),\n" +
                                "  (2022, 5, 5, 12, 'Адрес 5'),\n" +
                                "  (2022, 6, 6, 6, 'Адрес 6'),\n" +
                                "  (2022, 7, 7, 3, 'Адрес 7'),\n" +
                                "  (2022, 8, 8, 6, 'Адрес 8'),\n" +
                                "  (2022, 9, 9, 12, 'Адрес 9'),\n" +
                                "  (2022, 10, 10, 9, 'Адрес 10');\n";
                        statement.execute(query_ins);
                    } catch (Exception e) {
                        throw new Exception("Таблица не созданна. Создайте её.");
                    }
                    break;
                case 3:
                    System.out.println("\nТаблица Издания\n");
                    String query3 = "SELECT * FROM Издания";
                    ResultSet resultSet = statement.executeQuery(query3);
                    while (resultSet.next()) {
                        int id = resultSet.getInt("ИндексИздания");
                        String name = resultSet.getString("НазвИздания");
                        double price = resultSet.getDouble("СтоимостьЗаГод");
                        int id2 = resultSet.getInt("КодГруппыИзданий");
                        System.out.println(id + " " + name + " " + price + " " + id2);
                    }


                    System.out.println("\nТаблица Подписчики\n");
                    String query4 = "SELECT * FROM Подписчики";
                    ResultSet resultSet1 = statement.executeQuery(query4);
                    while (resultSet1.next()) {
                        int id = resultSet1.getInt("КодПодписчика");
                        String name = resultSet1.getString("ФамилияПодписчика");
                        String adress = resultSet1.getString("Адрес");
                        System.out.println(id + " " + name + " " + adress);
                    }

                    System.out.println("\nТаблица ГруппыИзданий\n");
                    String query5 = "SELECT * FROM ГруппыИзданий";
                    ResultSet resultSet2 = statement.executeQuery(query5);
                    while (resultSet2.next()) {
                        int id = resultSet2.getInt("КодГруппы");
                        String name = resultSet2.getString("НаименованиеГруппыИзданий");
                        double price = resultSet2.getDouble("ПроцентСкидки");
                        System.out.println(id + " " + name + " " + price);
                    }

                    System.out.println("\nТаблица Подписка\n");

                    String query6 = "SELECT * FROM Подписка";
                    ResultSet resultSet3 = statement.executeQuery(query6);
                    while (resultSet3.next()) {
                        int id = resultSet3.getInt("ГодПодписки");
                        int index = resultSet3.getInt("ИндексИздания");
                        int codePod = resultSet3.getInt("КодПодписчика");
                        int srok = resultSet3.getInt("СрокПодписки");
                        String name = resultSet3.getString("МестоДоставки");
                        System.out.println(id + " " + index + " " + codePod + " " + srok + " " + name);

                    }

                    connection.close();
                    break;
                default:
                    flag = false;
                    break;

            }
        }
    }
}