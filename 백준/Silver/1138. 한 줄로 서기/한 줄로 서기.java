import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] howManyTallPersons = new int[N];

        for (int i = 0; i < N; i++) {
            howManyTallPersons[i] = sc.nextInt();
        }

        ArrayList<Integer> positions = new ArrayList<>();

        for (int i = N - 1; i >= 0; i--) {
            positions.add(howManyTallPersons[i], i + 1);
        }

        for (int position : positions) {
            System.out.print(position + " ");
        }
    }
}