import java.io.*;
import java.util.*;

public class Main {
    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int count = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(count);
    }

    static void dfs(int x, int y, int depth) {
        if (x == 0 && y == C - 1) {
            if (depth == K) count++;
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny] && map[nx][ny] == '.') {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1);
                visited[nx][ny] = false;   
            }
        }
    }
}
