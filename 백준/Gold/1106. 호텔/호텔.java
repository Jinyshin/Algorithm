import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] cities = new int[N][2];
        for (int i = 0; i < N; i++) {
            st  = new StringTokenizer(br.readLine());
            cities[i][0] = Integer.parseInt(st.nextToken());
            cities[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // 주의: 한 번에 얻을 수 있는 고객의 수는 최대 100명이고, C명 이상이면 되므로
        // dp배열 크기를 C + 101로 설정한다.
        long[] dp = new long[C + 101];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < N; i++) {
            int cost = cities[i][0];
            int ppl = cities[i][1];
            for (int j = ppl; j < C + 101; j++) {
                // 도달 불가능한 값을 제외하는 조건 필수
                if (dp[j - ppl] != Long.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - ppl] + cost);
                }
            }
        }
        
        long answer = Long.MAX_VALUE;
        for (int i = C; i < C + 101; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);
    }
}

/*
홍보 가능한 도시 / 도시별로 홍보하는데 드는 비용 / 홍보하고 늘어나는 고객수
ex. 어떤 도시 / 9원 / 3명
투자 가능 비용 = 홍보비용 * 정수배
ex. 9원,3명 / 18원,6명 / 27원,9명
호텔 고객 최소한 C명 늘리기 위한 투자 비용의 최솟값 구하기

고객 i명을 늘릴때 필요한 최소 비용 = dp[i]
dp 최댓값으로 초기화
dp[i] = min(dp[i], dp[i-고객증가단위]+비용증가단위)
    i-고객증가단위 >= 0
*/