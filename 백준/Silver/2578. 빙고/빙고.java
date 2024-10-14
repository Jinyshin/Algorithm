/*
메모
- isVisited 갱신 시, 사회자가 부른 숫자가 빙고판에서 어디에 위치하는지를 확인하고 방문 처리해야한다.
- 빙고를 찾고->3빙고되면->프로그램 종료 로직을 구현하기 위해 findBingo 로직을 분리하였다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] numbers = new int[5][5];
    static String[] numsStr = new String[5];
    static int[][] bingoNumbers = new int[5][5];
    static boolean[] isVisited = new boolean[25];
    static int count;
    static List<int[]> bingos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빙고판 숫자 초기화
        for (int i = 0; i < 5; i++) {
            numsStr[i] = br.readLine();
            String[] strNums = numsStr[i].split(" ");
            for (int j = 0; j < 5; j++) {
                numbers[i][j] = Integer.parseInt(strNums[j]);
            }
        }

        // 사회자 숫자 초기화
        for (int i = 0; i < 5; i++) {
            numsStr[i] = br.readLine();
            String[] strNums = numsStr[i].split(" ");
            for (int j = 0; j < 5; j++) {
                bingoNumbers[i][j] = Integer.parseInt(strNums[j]);
            }
        }

        when3Bingo();
    }

    // 사회자 숫자의 몇 번째일 때 3빙고가 되는지
    private static void when3Bingo() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                count++;

                // 빙고판의 사회자 숫자 위치를 방문 처리
                int calledNumber = bingoNumbers[i][j];
                markVisited(calledNumber);

                // 빙고 찾기
                findBingo();

                // 3빙고 -> 프로그램 종료
                if (bingos.size() >= 3) {
                    System.out.println(count);
                    return;
                }
            }
        }
    }

    // 숫자가 빙고판에서 어디에 있는지 찾아 방문 처리
    private static void markVisited(int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (numbers[i][j] == number) {
                    isVisited[i * 5 + j] = true;  // 해당 숫자가 있는 칸을 방문 처리
                    return;
                }
            }
        }
    }

    // 빙고 찾기
    private static void findBingo() {
        // 가로 빙고 체크
        for (int i = 0; i < 5; i++) {
            // 각 행에 대해 확인
            boolean isBingo = true;
            int[] bingoRow = new int[5];
            for (int j = 0; j < 5; j++) {
                if (!isVisited[i * 5 + j]) {
                    isBingo = false;
                    break;
                }
                bingoRow[j] = i * 5 + j;  // 해당 칸의 위치 저장
            }
            if (isBingo && isNotBingoAdded(bingoRow)) {
                bingos.add(bingoRow);
            }
        }

        // 세로 빙고 체크
        for (int j = 0; j < 5; j++) {
            boolean isBingo = true;
            int[] bingoColumn = new int[5];
            for (int i = 0; i < 5; i++) {
                if (!isVisited[i * 5 + j]) {
                    isBingo = false;
                    break;
                }
                bingoColumn[i] = i * 5 + j;
            }
            if (isBingo && isNotBingoAdded(bingoColumn)) {
                bingos.add(bingoColumn);
            }
        }

        // 대각선 빙고 체크
        // 좌상단 -> 우하단 대각선
        boolean isBingo1 = true;
        int[] diagonal1 = new int[5];
        for (int i = 0; i < 5; i++) {
            if (!isVisited[i * 5 + i]) {
                isBingo1 = false;
                break;
            }
            diagonal1[i] = i * 5 + i;
        }
        if (isBingo1 && isNotBingoAdded(diagonal1)) {
            bingos.add(diagonal1);
        }

        // 우상단 -> 좌하단 대각선
        boolean isBingo2 = true;
        int[] diagonal2 = new int[5];
        for (int i = 0; i < 5; i++) {
            if (!isVisited[i * 5 + (4 - i)]) {
                isBingo2 = false;
                break;
            }
            diagonal2[i] = i * 5 + (4 - i);
        }
        if (isBingo2 && isNotBingoAdded(diagonal2)) {
            bingos.add(diagonal2);
        }
    }

    // 빙고가 이미 추가되었는지 확인하는 메서드
    private static boolean isNotBingoAdded(int[] bingo) {
        for (int[] existingBingo : bingos) {
            boolean isSame = true;
            for (int i = 0; i < 5; i++) {
                if (existingBingo[i] != bingo[i]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) return false;
        }
        return true;
    }
}