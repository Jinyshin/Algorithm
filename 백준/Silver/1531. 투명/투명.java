import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] howMany = new int[100][100];

        // 종이 좌표 입력 및 덮기 처리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1; // 0-based index
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    howMany[x][y]++;
                }
            }
        }

        // 보이지 않는 그림의 개수 계산
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (howMany[i][j] > M) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
