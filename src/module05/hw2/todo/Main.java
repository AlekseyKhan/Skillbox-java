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
        for (String command : commands) {
            System.out.print(command + ". ");
        }
        System.out.println();

        for (; ; ) {
            System.out.println("Введите команду:");
            String[] input = reader.nextLine()
                    .trim()
                    .split("\\s+", 2);

            String inputCommand = input[0].toUpperCase();
            String inputArguments = input.length > 1 ? input[1] : "";

            switch (inputCommand) {
                case "LIST":
                    if (!todoList.isEmpty()) {
                        for (int i = 0; i < todoList.size(); i++) {
                            System.out.println(i + ") " + todoList.get(i));
                        }
                    } else {
                        System.out.println("Список дел пуст!");
                    }
                    break;
                case "ADD":
                    if (!inputArguments.isEmpty()) {
                        if (inputArguments.matches("^\\d+\\s+.+")) {
                            String[] arr = inputArguments.split("\\s+", 2);
                            int position = Integer.parseInt(arr[0]);
                            String value = arr[1];

                            if (isPositionInList(todoList, position)) {
                                todoList.add(position, value);
                                System.out.println("Добавлена запись в позицию " + position);
                            } else {
                                System.out.println("Позиция указана неверно");
                            }
                        } else {
                            todoList.add(inputArguments);
                            System.out.println("Запись добавлена в конец списка");
                        }
                    } else {
                        System.out.println("Вы ввели ADD без параметров");
                    }
                    break;
                case "EDIT":
                    if (!inputArguments.isEmpty()) {
                        if (inputArguments.matches("^\\d+\\s+.+")) {
                            String[] arr = inputArguments.split("\\s+", 2);
                            int position = Integer.parseInt(arr[0]);
                            String value = arr[1];

                            if (isPositionInList(todoList, position)) {
                                System.out.println("Запись '" + todoList.get(position) + "' заменяется на '" + value + "'");
                                todoList.remove(position);
                                todoList.add(position, value);
                            } else {
                                System.out.println("Список пуст или нет такой позиции");
                            }
                        } else {
                            System.out.println("Нарушен синтаксис команды EDIT");
                        }
                    } else {
                        System.out.println("Вы ввели EDIT без параметров");
                    }
                    break;
                case "DELETE":
                    if (!inputArguments.isEmpty()) {
                        if (inputArguments.matches("^\\d+$")) {
                            int position = Integer.parseInt(inputArguments);

                            if (isPositionInList(todoList, position)) {
                                System.out.println("Удаляется " + position + " запись: " + todoList.get(position));
                                todoList.remove(position);
                            } else {
                                System.out.println("Список пуст или нет такой позиции");
                            }
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
                    for (String command : commands) {
                        System.out.println(command);
                    }
                    continue;
            }
        }
    }

    private static boolean isPositionInList(List<String> list, int position) {

        return (position >= 0 && position < list.size());

    }
}
