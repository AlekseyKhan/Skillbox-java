package module05.hw5;

import java.util.*;
import java.util.regex.Pattern;

public class Main {
    //Какие символы встречаются в номерах
    private static String regSymbols = "АБВГДЕЖЗИКЛМНОПРСТУФХЦЧЩЭЮЯ";
    //Диапозон номеров регионов
    private static int regionNumRange = 100;
    //Диапозон номеров
    private static int rangeOfRegNum = 1000;
    //паттерн на представление номера сЧЧЧссЧЧ
    private static Pattern vipNumber = Pattern.compile(
            "^[А-Я]{1}\\d{3}(?<!000)[А-Я]{2}\\d{2}(?<!00)$",
            Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        long start = System.currentTimeMillis();
        ArrayList<String> vipNumbers = generateNumbers(regionNumRange, regSymbols, rangeOfRegNum);
        long finish = System.currentTimeMillis();

        System.out.printf(
                "Генерация номеров заняла %.03f секунд\n" +
                "Всего номеров сгенерированно - %d\n",
                (finish - start) / 1000f, vipNumbers.size()
        );

//        for (String s : vipNumbers) {
//            System.out.println(s);
//        }


        boolean isFound;
        for (; ; ) {
            System.out.println("Введите номер машины или 'выход'");
            String input = reader.nextLine().trim().toUpperCase();

            if (input.equals("ВЫХОД")) {
                reader.close();
                break;
            } else if (vipNumber.matcher(input).matches()) {
                System.out.print("Последовательный поиск");
                start = System.nanoTime();
                isFound = iterateCheck(input, vipNumbers);
                finish = System.nanoTime();
                System.out.printf(" занял %.9f секунд с результатом %s\n", (finish - start) / 1000000000f, isFound);

                System.out.print("Бинарный поиск");
                start = System.nanoTime();
                isFound = binarySearch(input, vipNumbers);
                finish = System.nanoTime();
                System.out.printf(" занял %.9f секунд с результатом %s\n", (finish - start) / 1000000000f, isFound);

                System.out.print("Поиск по HashSet");
                HashSet<String> hashSet = new HashSet<>(vipNumbers);
                start = System.nanoTime();
                isFound = hashSetCheck(input, hashSet);
                finish = System.nanoTime();
                System.out.printf(" занял %.9f секунд с результатом %s\n", (finish - start) / 1000000000f, isFound);

                System.out.print("Поиск по TreeSet");
                TreeSet<String> treeSet = new TreeSet<>(vipNumbers);
                start = System.nanoTime();
                isFound = treeSetCheck(input, treeSet);
                finish = System.nanoTime();
                System.out.printf(" занял %.9f секунд с результатом %s\n", (finish - start) / 1000000000f, isFound);

                System.out.println(isFound ? "Номер найден в базе. Он блатной\n" : "Не найден в базе блатных номеров\n");


            } else {
                System.out.println("Некорректный ввод\n");
            }
        }
    }

    private static ArrayList<String> generateNumbers(int regionRange, String symbols, int numRange) {
        ArrayList<String> numbers = new ArrayList<>();
        System.out.println("Генерация номеров");
        for (int i = 0; i < regionRange; i++) {
            for (int j = 0; j < symbols.length(); j++) {
                for (int k = 0; k < numRange; k++) {
                    char c = symbols.charAt(j);
                    numbers.add(String.format("%s%03d%s%s%02d", c, k, c, c, i));
                }
            }
        }

        return numbers;
    }

    private static boolean iterateCheck(String value, ArrayList<String> lists) {
        for (String list : lists) {
            if (list.equals(value)) {
                return true;
            }
        }

        return false;
    }

    private static boolean binarySearch(String value, ArrayList<String> lists) {
        if (Collections.binarySearch(lists, value) < 0) {
            return false;
        } else {
            return false;
        }
    }

    private static boolean hashSetCheck(String value, HashSet<String> set) {
        if (set.contains(value)) {
            return true;
        }

        return false;
    }

    private static boolean treeSetCheck(String value, TreeSet<String> set) {
        if (set.contains(value)) {
            return true;
        }

        return false;
    }
}
