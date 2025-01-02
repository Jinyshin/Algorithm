/*
- 변수는 벌집의 위치와, 벌의 위치이다.
- 양쪽 끝값중에 더 큰 값을 벌통의 위치로 정한다.
- 다른 쪽 끝에 벌1을 둔다.
- 나머지 하나의 벌을 움직이면서 최대 값을 구한다.
 */
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] honey;
    static long[] preSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        N = Integer.parseInt(br.readLine());
        honey = new long[N + 1];
        preSum = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            honey[i] = Long.parseLong(st.nextToken());
            preSum[i] = preSum[i - 1] + honey[i];
        }

        long answer = 0;

        // 벌 - 꿀통 - 벌
        for (int i = 2; i < N; i++) {
            long cur = (preSum[i] - preSum[1]) + (preSum[N - 1] - preSum[i - 1]);
            answer = Math.max(answer, cur);
        }
        
        // 벌 - 벌 - 꿀통
        for (int i = 2; i < N; i++) {
            long cur = (preSum[N] - preSum[1] - honey[i]) + (preSum[N] - preSum[i]);
            answer = Math.max(answer, cur);
        }

        // 꿀통 - 벌 - 벌
        for (int i = 2; i < N; i++) {
            long cur = (preSum[N - 1] - honey[i]) + preSum[i - 1];
            answer = Math.max(answer, cur);
        }

        // 결과 출력
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
