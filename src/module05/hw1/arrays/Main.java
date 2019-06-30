package module05.hw1.arrays;

public class Main {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] colors = text.split("\\s+");

        for (int i = 0; i < colors.length; i++) {
            System.out.println(i + ") " + colors[i]);
        }

        String[] revers = new String[colors.length];
        for (int i = 0; i < revers.length ; i++) {
            revers[i] = colors[colors.length - i - 1];
            System.out.println(i + ") " + revers[i]);
        }
    }
}
