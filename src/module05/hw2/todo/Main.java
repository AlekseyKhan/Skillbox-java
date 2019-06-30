package module05.hw2.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> commands = new ArrayList<>() {{
            add("ADD");
            add("EDIT");
            add("DELETE");
            add("LIST");
            add("EXIT");
        }};

        List<String> todoList = new ArrayList<>();

        Scanner reader = new Scanner(System.in);

        System.out.println("Для работы, вы можете использовать следующие команды:");
        for (String s :commands) {
            System.out.print(s + ". ");
        }
        System.out.println();

        for(;;) {
            System.out.println("Введите команду:");
            String[] input = reader.nextLine()
                    .trim()
                    .split("\\s+",2);

            switch (input[0].toUpperCase()) {
                case "LIST":
                    if (!todoList.isEmpty()) {
                        for (int i = 0; i < todoList.size(); i++) {
                            System.out.println(i + ") " + todoList.get(i));
                        }
                    } else System.out.println("Список дел пуст!");
                    break;
                case "ADD":
                    if (input.length > 1) {
                        if (input[1].matches("^\\d+\\s+.+")) {
                            String[] arr = input[1].split("\\s+", 2);
                            int position = Integer.parseInt(arr[0]);
                            if (position >= 0 && position < todoList.size()) {
                                todoList.add(Integer.parseInt(arr[0]), arr[1]);
                            } else System.out.println("Позиция указана неверно");
                        } else {
                            todoList.add(input[1]);
                        }
                    } else {
                        System.out.println("Вы ввели ADD без параметров");
                    }
                    break;
                case "EDIT":
                    if (input.length > 1) {
                        if (input[1].matches("^\\d+\\s+.+")) {
                            String[] arr = input[1].split("\\s+", 2);
                            int position = Integer.parseInt(arr[0]);
                            if (position >= 0 && position < todoList.size() && !todoList.isEmpty()) {
                                todoList.remove(position);
                                todoList.add(position, arr[1]);
                            } else System.out.println("Список пуст или нет такой позиции");
                        } else System.out.println("Нарушен синтаксис команды EDIT");
                    } else {
                        System.out.println("Вы ввели EDIT без параметров");
                    }
                    break;
                case "DELETE":
                    if (input.length > 1) {
                        if (input[1].matches("^\\d+$")) {
                            int position = Integer.parseInt(input[1]);
                            if (position >= 0 && position < todoList.size() && !todoList.isEmpty()) {
                                todoList.remove(position);
                            } else System.out.println("Список пуст или нет такой позиции");
                        } else {
                            System.out.println("Нарушен синтаксис команды DELETE");
                        }
                    } else {
                        System.out.println("Вы ввели DELETE без параметров");
                    }
                    break;
                case "EXIT":
                    reader.close();
                    return;
                default:
                    System.out.println("Доступные команды:");
                    for (String command :commands) {
                        System.out.println(command);
                    }
                    continue;
            }
        }

    }


}
