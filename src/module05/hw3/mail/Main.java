package module05.hw3.mail;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static Pattern pattern =
            Pattern.compile("^((\\w|[-+])+(\\.[w-]+)*@[\\w-]+((\\.[\\d\\p{Alpha}]+)*(\\.\\p{Alpha}{2,})*)*)$");
    private static Matcher matcher;

    public static void main(String[] args) {
        Set<String> emails = new HashSet<>();
        Scanner reader = new Scanner(System.in);

        for (; ; ) {
            System.out.println("Введите команду");
            String[] in = reader.nextLine()
                    .trim()
                    .split("\\s+", 2);

            String inputCommand = in[0].toUpperCase();
            String inputArgument = in.length > 1 ? in[1] : "";

            switch (inputCommand) {
                case "ADD":
                    if (pattern.matcher(inputArgument).matches()) {
                        emails.add(inputArgument);
                        System.out.println("Запись добавлена");
                    } else {
                        System.out.println("Электронный адрес введен некорректно");
                    }
                    break;
                case "LIST":
                    if(emails.size() > 0) {
                        for (String email : emails) {
                            System.out.println(email);
                        }
                    } else {
                        System.out.println("Список эл. адресов пуст");
                    }
                    break;
                case "EXIT" :
                    reader.close();
                    return;
                default:
                    continue;
            }
        }

    }
}
