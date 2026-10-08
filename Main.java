import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество элементов в массиве:");
        int n = sc.nextInt();
        sc.nextLine();
        String[] array = new String[n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLine();
        }
        var result = maj(array);
        if (result == null) {
            System.out.println("Мажоритарный элемент не найден :(");
        } else {
            System.out.println("Мажоритарный элемент: " + result);
        }
    }
    public static <T> T maj(T[] arr) {
        T cand = null;
        int count = 0;
        for (T elem : arr) {
            if (count == 0) {
                cand = elem;
                count++;
            } else if (Objects.equals(cand, elem)) {
                count++;
            } else {
                count--;
            }
        }
        int occurrences = 0;
        for (T elem : arr) {
            if (Objects.equals(cand, elem)) {
                occurrences++;
            }
        }
        if (occurrences > arr.length / 2) {
            return cand;
        }
        return null;
    }
}