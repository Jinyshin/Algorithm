import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] tri = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st  = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[0][0] = tri[0][0];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int maxNum = dp[i-1][j];
                if (j != 0) {
                    maxNum = Math.max(maxNum, dp[i-1][j-1]);
                }
                dp[i][j] = maxNum + tri[i][j];
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n-1][i]);
        }
        System.out.println(max);
    }
}

/*
n: 삼각형의 높이
triangle[n][n]
이동: [n+1][i] 또는 [n+1][i+1]
백트래킹으로 모든 경로탐색-최대 구하기
    if n == 500 -> 500! * 2^500..
    -> 기각
dp
    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])
    -> O(n)으로 가능
*/