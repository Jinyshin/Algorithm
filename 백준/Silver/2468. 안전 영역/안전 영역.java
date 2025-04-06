import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int maxHeight = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];

        // 지도 높이 입력 받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int result = 0;

        // 강우량 0부터 최대 높이까지 시뮬레이션
        for (int h = 0; h <= maxHeight; h++) {
            visited = new boolean[n][n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 현재 높이보다 높은 영역 && 방문하지 않았으면 DFS 시작
                    if (!visited[i][j] && map[i][j] > h) {
                        dfs(i, j, h);
                        count++;
                    }
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);
    }
    
    static void dfs(int x, int y, int h) {
        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && map[nx][ny] > h) {
                    dfs(nx, ny, h);
                }
            }
        }
    }
}