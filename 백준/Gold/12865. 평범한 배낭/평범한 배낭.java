import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] wv = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            wv[i][0] = V;
            wv[i][1] = W;
        }

        int[][] mv = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                int num1 = mv[i-1][j];
                int num2 = 0;
                if (j - wv[i][1] >= 0) {
                    num2 = mv[i-1][j - wv[i][1]] + wv[i][0];
                }
                mv[i][j] = Math.max(num1, num2);
            }
        }

        System.out.println(mv[N][K]);
    }
}