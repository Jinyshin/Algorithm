import java.io.*;

public class Main {
    static int N;
    static int[] stairs;
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // dp 배열 초기화
        int[] dp = new int[N + 1];
        dp[1] = stairs[1];
        if (N >= 2) dp[2] = stairs[1] + stairs[2];
        if (N >= 3) dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);

        // dp 배열 채우기
        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i]);
        }

        // 출력
        System.out.println(dp[N]);
    }
}