import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            String row = br.readLine();
            for (int c = 0; c < M; c++) {
                maze[r][c] = row.charAt(c) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(maze[N - 1][M - 1]);
    }

    public static void bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int y = curr[0];
            int x = curr[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (!visited[ny][nx] && maze[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        maze[ny][nx] = maze[y][x] + 1;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
