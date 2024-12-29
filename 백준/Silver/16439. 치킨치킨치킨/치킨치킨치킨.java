/*
Step 1. 치킨들의 조합 목록을 구한다.
Step 2. 각 치킨들의 조합별로 선호토 max 구하고 출력하기
 */
import java.util.*;

public class Main {
    static int N, M;
    static int[][] preferences;
    static int maxSum;
    static ArrayList<Integer[]> combinationList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        preferences = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                preferences[i][j] = sc.nextInt();
            }
        }
        getCombinationList();
        getMaxsum();
    }

    // 최대만족도 구하기
    public static void getMaxsum() {
        for (Integer[] chickenCombination : combinationList) {
            int preferencesSum = 0;
            for (int[] preference : preferences) { // 각 사람의 만족도(최대 선호도) 구하기
                int personMaxPreference = 0;
                for (Integer chickenIndex : chickenCombination) {
                    if (personMaxPreference < preference[chickenIndex]) {
                        personMaxPreference = preference[chickenIndex];
                    }
                }
                preferencesSum += personMaxPreference;
            }

            if (preferencesSum > maxSum) {
                maxSum = preferencesSum;
            }
        }
        System.out.println(maxSum);
    }

    // 조합 목록 구하기
    public static void getCombinationList() {
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                for (int k = j + 1; k < M; k++) {
                    Integer[] combination = {i, j, k};
                    if (!combinationList.contains(combination)) {
                        combinationList.add(combination);
                    }
                }
            }
        }
    }

}
