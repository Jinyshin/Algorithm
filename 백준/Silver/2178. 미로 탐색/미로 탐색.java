import java.util.*;

public class Main {
    static int n, m;
    static int[] dy = new int[]{-1, 1, 0, 0}; // 상하좌우
    static int[] dx = new int[]{0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        int[][] maze = new int[n][m];

        for(int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0, maze));
    }

    public static int bfs(int row, int col, int[][] maze) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col}); // 시작 위치값을 추가

        while (true) {
            int[] current = q.poll();
            int y = current[0];
            int x = current[1];

            if (y == n - 1 && x == m - 1) {
                return maze[y][x];
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m && maze[ny][nx] == 1) {
                    maze[ny][nx] = maze[y][x] + 1; // 방문 횟수 갱신
                    q.add(new int[]{ny, nx}); // 큐에 추가
                }
            }
        }
    }
}

/*
인접한 칸이면서 1만 탐색 가능
최소칸수 -> bfs
매번 탐색할 때마다 기존 큐에 조건에 부합하는 인접 좌표를 추가한다.
*/