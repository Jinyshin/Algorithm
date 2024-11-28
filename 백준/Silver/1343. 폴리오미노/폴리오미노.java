import java.util.Scanner;

public class Main {
    static StringBuilder result;
    static String board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = sc.nextLine();
        result = new StringBuilder(board);

        if (solve(0)) {
            System.out.println(result.toString());
        } else {
            System.out.println("-1");
        }
    }

    private static boolean solve(int idx) {
        // 끝까지 도달했다면 성공
        if (idx == board.length()) {
            return true;
        }

        // 현재 위치가 '.'이면 다음 위치로
        if (board.charAt(idx) == '.') {
            return solve(idx + 1);
        }

        // 현재 위치가 'X'일 때
        if (board.charAt(idx) == 'X') {
            // AAAA로 덮을 수 있는지 확인
            if (idx + 3 < board.length() &&
                    board.charAt(idx + 1) == 'X' &&
                    board.charAt(idx + 2) == 'X' &&
                    board.charAt(idx + 3) == 'X') {

                // AAAA로 덮기
                for (int i = 0; i < 4; i++) {
                    result.setCharAt(idx + i, 'A');
                }

                if (solve(idx + 4)) {
                    return true;
                }

                // 실패시 원상복구
                for (int i = 0; i < 4; i++) {
                    result.setCharAt(idx + i, 'X');
                }
            }

            // BB로 덮을 수 있는지 확인
            if (idx + 1 < board.length() && board.charAt(idx + 1) == 'X') {
                // BB로 덮기
                result.setCharAt(idx, 'B');
                result.setCharAt(idx + 1, 'B');

                if (solve(idx + 2)) {
                    return true;
                }

                // 실패시 원상복구
                result.setCharAt(idx, 'X');
                result.setCharAt(idx + 1, 'X');
            }
        }

        return false;
    }
}