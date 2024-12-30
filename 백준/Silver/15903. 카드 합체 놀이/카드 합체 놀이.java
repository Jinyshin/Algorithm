import java.util.*;

public class Main {
    static int n, m;
    static long[] cardNumbers;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        cardNumbers = new long[n];
        for (int i = 0; i < n; i++) {
            cardNumbers[i] = sc.nextInt();
        }

        for (int j = 0; j < m; j++) {
            Arrays.sort(cardNumbers);
            long x = cardNumbers[0];
            long y = cardNumbers[1];
            long xy = x + y;
            cardNumbers[0] = xy;
            cardNumbers[1] = xy;
        }

        System.out.println(Arrays.stream(cardNumbers).sum());
    }
}