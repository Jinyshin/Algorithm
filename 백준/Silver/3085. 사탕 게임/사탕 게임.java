import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static char[][] board;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int maxCandy = 0;
        // 가로&세로쌍 탐색: 인접 사탕 서로위치바꾸고 -> 최대연속개수 구하는 함수호출 -> Math.max(max, 현재값)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 오른쪽 사탕과 교환
                if (j + 1 < N) {
                    swap(i,j,i,j+1);
                    maxCandy = Math.max(maxCandy, calcMaxCandy());
                    swap(i,j,i,j+1); // 원래대로
                }
                // 아래
                if (i + 1 < N) {
                    swap(i,j,i+1,j);
                    maxCandy = Math.max(maxCandy, calcMaxCandy());
                    swap(i,j,i+1,j);
                }
            }
        }
        System.out.println(maxCandy);
    }
    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }
    public static int calcMaxCandy() {
        int max = 0;

        // 행
        for (int i = 0; i < N; i++) {
            int length = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j-1]) length++;
                else{
                    max = Math.max(max, length);
                    length = 1;
                }
            }
            max = Math.max(max, length);
        }

        // 열
        for (int j = 0; j < N; j++) {
            int length = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i - 1][j]) length++;
                else {
                    max = Math.max(max, length);
                    length = 1;
                }
            }
            max = Math.max(max, length);
        }
        return max;
    }
}