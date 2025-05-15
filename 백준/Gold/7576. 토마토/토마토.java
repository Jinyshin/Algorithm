import java.util.*;
import java.io.*;

public class Main {
    static int n, m, zeroCount = 0;
    static int[][] box;
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};
    static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 0) zeroCount++;
                else if (box[i][j] == 1) q.add(new int[]{j, i});
            }
        }

        if (zeroCount == 0) {
            System.out.println(0);
            return;
        }

        bfs(box, q);
        System.out.println(zeroCount > 0 ? -1 : min);
    }

    static void bfs(int[][] box, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int[] xy = q.poll();
                int x = xy[0], y = xy[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && box[ny][nx] == 0) {
                        box[ny][nx] = 1;
                        zeroCount--;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            min++;
        }
        if (min > 0) min--; // 마지막 불필요한 증가 제거
    }
}