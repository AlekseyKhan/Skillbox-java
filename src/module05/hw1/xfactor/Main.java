package module05.hw1.xfactor;

public class Main {
    public static void main(String[] args) {
        int size = 5;
        String[] arr = new String[size];
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i + j + 1) == size || i == j) {
                    str.append('X');
                } else {
                    str.append(" ");
                }
            }
            arr[i] = str.toString();
            str.delete(0, str.length());
        }

        for (String s :arr) {
            System.out.println(s);
        }
    }
}
