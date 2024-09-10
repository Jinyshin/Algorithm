import java.util.Scanner;

public class Main {
    static int[] queens;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        queens = new int[N];

        backTracking(0, N);
        System.out.println(answer);
    }

    static void backTracking(int row, int n) {
        // 끝까지 탐색완료했다면 성공(모든 행마다 1개씩 퀸 배치 성공한 경우)
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                queens[row] = col; // 퀸 배치
                backTracking(row + 1, n);
                queens[row] = -1; // 배치 취소
            }
        }
    }

    // 현재 위치에 퀸 배치 가능한지 검사
    static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(row - i) == Math.abs(col - queens[i])) return false;
        }
        return true;
    }
}