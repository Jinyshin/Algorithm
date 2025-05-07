import java.io.*;
import java.util.*;

class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{0,0,-1,1,-1,1,-1,1};
    static int[] dy = new int[]{-1,1,0,0,-1,-1,1,1};
    static int w, h;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        List<Integer> counts = new ArrayList<>();
        while(w != 0 && h != 0) {
            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(j, i);
                        cnt++;
                    }
                }
            }
            counts.add(cnt);
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < counts.size(); i++) {
            System.out.println(counts.get(i));
        }
    }
    
    static void dfs(int x, int y) {
        visited[y][x] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < w && ny >= 0 && ny < h 
                && !visited[ny][nx] && map[ny][nx] == 1) {
                dfs(nx, ny);
            }
        }
    }
}