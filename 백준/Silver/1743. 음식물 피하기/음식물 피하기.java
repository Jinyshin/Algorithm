/*
각 음식물 덩어리의 크기 계산 -> 그중에 가장 큰 값 출력
- 방문한 좌표 다시 방문 x, 하나의 덩어리 크기 추적 -> visited, size 변수 활용
- 인접 위치(상하좌우) 탐색을 위한 방향 변수 directions 활용
 */

import java.util.Scanner;

public class Main {
    static int size;
    static int maxSize = 0;
    static boolean[][] visited;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] count = s.split(" ");

        int N = Integer.parseInt(count[0]);
        int M = Integer.parseInt(count[1]);
        int K = Integer.parseInt(count[2]);

        int[][] foodMap = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            String[] rc = sc.nextLine().split(" ");
            int y = Integer.parseInt(rc[0]) - 1;
            int x = Integer.parseInt(rc[1]) - 1;
            foodMap[y][x] = 1;
        }

        findLargestFood(foodMap, N, M);
        System.out.println(maxSize);
    }

    public static void findLargestFood(int[][] foodMap, int N, int M) {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (foodMap[y][x] == 1 && !visited[y][x]) {
                    size = 0;
                    dfs(foodMap, N, M, y, x);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
    }

    // dfs - 인접한 음식물 덩어리 크기 구하기
    public static void dfs(int[][] foodMap, int N, int M, int y, int x) {
        visited[y][x] = true;
        size++;

        for (int[] dir : directions) {
            int ny = y + dir[0];
            int nx = x + dir[1];

            if (ny >= 0 && ny < N && nx >= 0 && nx < M && foodMap[ny][nx] == 1 && !visited[ny][nx]) {
                dfs(foodMap, N, M, ny, nx);
            }
        }
    }
}
