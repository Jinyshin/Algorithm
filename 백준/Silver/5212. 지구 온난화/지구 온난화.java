import java.util.*;
import java.io.*;

class Main {
    static int R, C;
    static char[][] currMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        currMap = new char[R][C];
        for (int i = 0; i < R; i++) {
            currMap[i] = br.readLine().toCharArray();
        }

        char[][] afterMap = getAfterMap();
        printAfterMap(afterMap);
    }

    // 50년 후 지도 생성
    public static char[][] getAfterMap() {
        char[][] afterMap = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (currMap[i][j] == 'X' && countWater(i, j) < 3) {
                    afterMap[i][j] = 'X';
                } else {
                    afterMap[i][j] = '.';
                }
            }
        }
        return afterMap;
    }

    // 인접한 . 개수 계산. 끝값인 경우 포함.
    public static int countWater(int x, int y) {
        int count = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C || currMap[nx][ny] == '.') {
                count++;
            }
        }
        return count;
    }

    // 50년 후의 지도를 최소직사각형 크기로 출력
    public static void printAfterMap(char[][] map) {
        int minX = R, maxX = -1, minY = C, maxY = -1;

        // 'X' 좌표 최대, 최소 범위 계산
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
