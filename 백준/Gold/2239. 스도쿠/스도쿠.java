/*
풀다 만 스도쿠 문제를 푸는 프로그램 작성하기
- board: 스도쿠 숫자 값들이 입력되는 9*9 크기의 배열
- SudokuSolver class:
    - solve(): 스도쿠 판의 숫자들을 돌면서 문제를 푸는 함수
    - printBoard(): 다 푼 스도쿠 판을 출력하는 함수

solve() 로직
- 0인 칸에서 1-9 loop, isValid -> 해당 값으로 숫자 변경
    - 그 후 solve() 재귀호출. -> if 1-9 다 안되면 재귀 break
- isValid(): 특정 숫자를 넣을 수 있는지 확인하는 함수
    - 행, 열, 3*3 칸 검사
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        sc.close();

        SudokuSolver solver = new SudokuSolver(board);
        solver.solve(0, 0);
        solver.printBoard();
    }
}

class SudokuSolver {
    private int[][] board;

    public SudokuSolver(int[][] board) {
        this.board = board;
    }

    public boolean solve(int row, int col) {
        if (row == 9) return true; // 모든 행과 열을 채웠을 때 완성된 상태로 판단

        if (col == 9) return solve(row + 1, 0); // 다음 행의 첫 열로 이동
        if (board[row][col] != 0) return solve(row, col + 1); // 이미 숫자가 채워진 경우 다음 칸으로 이동

        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;
                if (solve(row, col + 1)) return true; // 정답을 찾으면 재귀 종료
                board[row][col] = 0; // 백트래킹
            }
        }

        return false; // 가능한 숫자가 없으면 false 반환하여 백트래킹
    }

//    public void solve(int row, int col) {
//        if (row == 9) return;
//        if (col == 9) {
//            solve(row + 1, 0);
//            return;
//        }
//        if (board[row][col] != 0) {
//            solve(row, col + 1);
//            return;
//        }
//
//        for (int num = 1; num <= 9; num++) {
//            if(isValid(row, col, num)) {
//                board[row][col] = num;
//                solve(row, col + 1);
//                board[row][col] = 0; // 백트래킹 처리
//            }
//        }
//    }


    public boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}