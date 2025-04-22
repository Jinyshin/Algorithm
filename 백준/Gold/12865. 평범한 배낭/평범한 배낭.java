import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] wv = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            wv[i][0] = Integer.parseInt(st.nextToken());
            wv[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int[][] maxV = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                int num1 = maxV[i - 1][j];
                int num2 = 0;
                if (j >= wv[i][0]) {
                    num2 = wv[i][1] + maxV[i - 1][j - wv[i][0]];
                }
                maxV[i][j] = Math.max(num1, num2);
            }
        }

        System.out.println(maxV[N][K]);
    }
}