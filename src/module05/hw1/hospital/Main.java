package module05.hw1.hospital;

public class Main {
    static final double MIN_FINE_TEMPERATURE = 36.2;
    static final double MAX_FINE_TEMPERATURE = 36.9;

    public static void main(String[] args) {
        double[] t = new double[30];

        double variant;
        double averageTemperature = 0.0;
        int countFine = 0;
        for (int i = 0; i < t.length; i++) {
            variant = Math.round(Math.random()*80);
            variant /= 10;
            t[i] = 32 + variant;
            System.out.println(t[i]);

            averageTemperature += t[i];
            if (t[i] >= MIN_FINE_TEMPERATURE && t[i] <= MAX_FINE_TEMPERATURE) {
                countFine++;
            }
        }

        System.out.println("Количество здоровых пациентов: " + countFine);
        System.out.printf("Средняя температура: %.1f", averageTemperature / t.length);
    }
}
