import java.util.Scanner;

public class Main {
    static int n;
    static int[] dp = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        System.out.println(countMinCoin(n));
    }

    private static int countMinCoin(int n) {
        if (n < 0) return -1;  // 음수 체크를 가장 먼저!
        if (dp[n] != Integer.MAX_VALUE) return dp[n];

        if (n == 0) return 0;
        if (n == 1 || n == 3) return -1;
        if (n == 2 || n == 5) return 1;
        
        int minus2 = countMinCoin(n - 2);
        int minus5 = countMinCoin(n - 5);

        int result;
        if (minus2 == -1 && minus5 == -1) {
            result = -1;
        } else if (minus2 == -1) {
            result = minus5 + 1;
        } else if (minus5 == -1) {
            result = minus2 + 1;
        } else {
            result = Math.min(minus2, minus5) + 1;
        }

        dp[n] = result;
        return result;
    }
}