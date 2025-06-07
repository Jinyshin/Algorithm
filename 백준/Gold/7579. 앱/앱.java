import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[] currMemUsage = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            currMemUsage[i] = Integer.parseInt(st.nextToken());
        }

        int[] cArr = new int[N + 1];
        int totalCost = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cArr[i] = Integer.parseInt(st.nextToken());
            totalCost += cArr[i];
        }

        int[] dp = new int[totalCost + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = totalCost; j >= cArr[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cArr[i]] + currMemUsage[i]);
            }
        }

        for (int i = 0; i <= totalCost; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}
