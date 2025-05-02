import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[N + 1]; // 0 ~ N칸
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        for (int i = 0; i <= N; i++) {
            if (i + 1 <= N) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }
            if (i + i / 2 <= N) {
                dp[i + i / 2] = Math.min(dp[i + i / 2], dp[i] + 1);
            }
        }
        
        System.out.println((dp[N] <= K) ? "minigimbob" : "water");
    }
}

/*
계단 0번 ~ N번 칸, K == 행동 횟수
행동 option at ith계단
    1. i++
    2. i = i + tail(i/2)
K번째일때 N번 계단 도달 -> minigimbob
else -> water

--

문제에는 K번째일때 N칸에 도착할수있는지를 물어봤지만, N칸(dp[N])까지 최대 K번만에 도착하기만 하면 됨.
- 0,1칸일때 0 + 0/2 = 0, 1 + 1/2 = 1 이기 때문에, 필요한 경우 헛도는 횟수를 추가할 수 있기 때문.!!!
- 따라서, 최소 횟수를 구하는 방향으로 생각한다.
*/
