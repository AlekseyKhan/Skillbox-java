package module05.hw4.phonebook;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Main {
    //для простоты заменил на 6 значное число начинающееся с 7 или 8
    private static Pattern PHONENUMBER = Pattern.compile("^(7|8)(\\d{5})$");
    //для теста используются два слова с латинскими символами
    private static Pattern NAME = Pattern.compile("[A-Z]{1}[a-z]+\\s[A-Z]{1}[a-z]*$");
    private static TreeMap<String, String> phoneBook = new TreeMap<>();

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        for (; ; ) {
            System.out.println("Введите запрос");
            String input = reader.nextLine().trim();

            if (input.toUpperCase().equals("EXIT")) {
                reader.close();
                break;

            } else if (input.toUpperCase().equals("LIST")) {
                if (phoneBook.size() > 0) {
                    for (Map.Entry name : phoneBook.entrySet()) {
                        System.out.printf("Абонент %s: %s\n", name.getKey(), name.getValue());
                    }
                } else {
                    System.out.println("Книга пуста");
                }

            } else if (isPhoneNumber(input.replaceAll("\\D+", ""))) {
                String phoneNumber = input.replaceAll("\\D+", "");
                if (phoneBook.containsValue(phoneNumber)) {
                    System.out.printf("Найдено: %s - %s\n", findNameByNumber(phoneNumber), phoneNumber);
                } else {
                    System.out.println("Введите имя контакта:");
                    String contactName = reader.nextLine();
                    phoneBook.put(contactName, phoneNumber);
                    System.out.println("Запись добавлена");
                }
            } else if (NAME.matcher(input).matches()) {
                String contactName = input;
                if (phoneBook.containsKey(contactName)) {
                    System.out.printf("Найден контакт %s с номером %s\n", contactName, phoneBook.get(contactName));
                } else {
                    System.out.println("Данного пользователя нет в телефонной книге");
                    for (; ; ) {
                        System.out.println("Введите номер телефона:");
                        String inputNumber = reader.nextLine().trim();
                        if (inputNumber.toUpperCase().equals("EXIT")) {
                            break;
                        }
                        if (isPhoneNumber(inputNumber)) {
                            phoneBook.put(contactName, inputNumber);
                            break;

                        } else {
                            System.out.println("Неверный формат номера, повторите или 'exit'");
                        }
                    }
                }
            } else {
                System.out.println("Что-то пошло не так, повторите");
            }
        }
    }

    private static String findNameByNumber(String searchObject) {

        for (Map.Entry<String, String> pair : phoneBook.entrySet()) {
            if (pair.getValue().equals(searchObject)) {
                return pair.getKey();
            }
        }

        return null;
    }

    private static boolean isPhoneNumber(String input) {
        if (PHONENUMBER.matcher(input).matches()) {
            return true;
        }

        return false;
    }

}
