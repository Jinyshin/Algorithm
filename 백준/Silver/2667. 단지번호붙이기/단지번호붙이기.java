import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> groups = new ArrayList<>(); // 단지 수를 저장
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        // 입력받기
        for (int i = 0; i < N; i++) {
            String houses = sc.next();
            for (int j = 0; j < N; j++) {
                int isHouse = houses.charAt(j) - '0';
                map[i][j] = isHouse;
                visited[i][j] = false;
            }
        }

        // 모든 좌표 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int count = dfs(i, j); // 새로운 단지 탐색
                    groups.add(count); // 단지 수 저장
                }
            }
        }

        // 탐색 후 출력
        System.out.println(groups.size());
        Collections.sort(groups);
        for (int group: groups) {
            System.out.println(group);
        }
    }

    static int dfs(int y, int x) {
        visited[y][x] = true;
        int count  = 1;

        // (x,y) 기준으로 상하좌우 위치 탐색
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 지도 크기 내부의 인덱스여야함
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    count += dfs(ny, nx);
                }
            }
        }
        return count;
    }
}