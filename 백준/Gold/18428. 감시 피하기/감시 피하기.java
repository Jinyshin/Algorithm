import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static List<int[]> teachers = new ArrayList<>();
    static boolean avoid = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = line[j].charAt(0);
                if (map[i][j] == 'T') teachers.add(new int[]{i, j});
            }
        }

        placeO(0);

        System.out.println(avoid ? "YES" : "NO");
    }

    static void placeO(int count) {
        if (count == 3) {
            if (isOk()) avoid = true;
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    placeO(count + 1);
                    if (avoid) return; // 피할 수 있는 경우 찾으면 -> 탐색 종료
                    map[i][j] = 'X'; // 원상복구
                }
            }
        }
    }

    // 모든 선생 위치에서 감시 진행
    static boolean isOk() {
        for (int[] t : teachers) {
            if (!canAvoid(t[0], t[1])) return false;
        }
        return true;
    }

    // 감시하기
    static boolean canAvoid(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            int nx = x, ny = y;
            while (true) {
                nx += dx[d];
                ny += dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 'O') break;
                if (map[nx][ny] == 'S') return false; // 학생 감시됨
            }
        }
        return true;
    }
}

/*
- 입력: 선생님 좌표 기록까지 하기
- 장애물 배치
    - 빈칸중에 3개 선택
    - 각 선생님 위치->감시하기
    - 모든 학생 감시 실패 -> "YES"
- 감시하기
    - 선생님 좌표에서 상하좌우 확인
    - 장애물 만나면 감시 종료
    - 학생 만나면 감시 실패
- 모든 장애물 조합 확인 -> 감시 피할 수 x -> "NO"
*/