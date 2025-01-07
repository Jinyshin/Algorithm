/*
주의: 입력값 n의 범위는 1~1000
-> int[] dp = new int[n + 1]; 이렇게 선언하면, dp[2]=2 에서 런타임 에러 (ArrayIndexOutOfBounds) 발생
    - 애초에 1001을 선언하거나, 조건문을 걸어주면 되는데, 더 간단한 방법인 전자로 ㄱㄱ
-> 이 문제에서의 점화식은 피보나치 수열임. 초기에는 천천히 증가하지만, 이후에는 기하급수적으로 증가
    - n = 50쯤만 되어도 정수 범위를 넘어가기 때문에 int[] dp에 정상값 저장 불가능
    - 따라서, 모듈로 연산을 먼저 해주고 저장해야 한다.
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        bw.write(dp[n] + "");
        bw.flush();
        br.close();
        bw.close();
    }
}