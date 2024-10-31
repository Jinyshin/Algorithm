/*
로또 문제를 풀어보자

1~49 중에 숫자 6개를 고른다.
49개 중에 k개의 수를 골라 집합 S 만들고 -> 그 수만 가지고 번호를 선택한다.
kC6가지의 경우의 수를 출력한다.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<int[]> combinations = new ArrayList<>();
    private static int[] currentCombination = new int[6];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String[] input = sc.nextLine().split(" ");
            int k = Integer.parseInt(input[0]);
            if (k == 0) break;

            int[] S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(input[i + 1]);
            }

            combinations.clear();
            generateCombinations(S, 0, 0);
            for (int[] combination : combinations) {
                for (int num : combination) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // S 배열에서 가능한 모든 6개 숫자 조합 목록 만들기
    private static void generateCombinations(int[] S, int start, int current) {
        // 6개 조합이 생성되면 -> 조합 목록에 추가 후 return
        if (current == 6) {
            combinations.add(currentCombination.clone());
            return;
        }

        for (int i = start; i < S.length; i++) {
            currentCombination[current] = S[i];
            generateCombinations(S, i + 1, current + 1);
        }
    }
}