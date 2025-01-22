import java.io.*;
import java.util.*;

public class Main {
    public static final List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
    public static List<List<Integer>> permutations = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] square = new int[3][3];
        for (int i = 0; i < 3; i++) {
            square[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 가능한 모든 3*3 배열 만들고 매직스퀘어라면 최솟값을 갱신하여 정답값 구하기
        genPermutations(new ArrayList<>(), new boolean[9]);
        int minCost = Integer.MAX_VALUE;
        for (List<Integer> p: permutations) {
            if (isMagicSquare(p)) {
                int tempCost = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (square[i][j] != p.get(i*3 + j)) {
                            tempCost += Math.abs(square[i][j] - p.get(i*3 + j));
                        }
                    }
                }
                minCost = Math.min(minCost, tempCost);
            }
        }
        System.out.println(minCost)        ;
    }

    public static void genPermutations(List<Integer> current, boolean[] used) {
        if (current.size() == 9) {
            permutations.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (used[i]) continue; // 이미 사용된 숫자면 건너뛴다.

            used[i] = true;
            current.add(nums.get(i));
            genPermutations(current, used); // 새 숫자 추가하고, 재귀호출하기
            current.remove(current.size() - 1); // 제일 끝에 추가한 숫자 제거하기
            used[i] = false;
        }
    }

    public static boolean isMagicSquare(List<Integer> square) {
        int[][] grid = {
                {square.get(0), square.get(1), square.get(2)},
                {square.get(3), square.get(4), square.get(5)},
                {square.get(6), square.get(7), square.get(8)}
        };

        for (int i = 0; i < 3; i++) {
            int rowSum = grid[i][0] + grid[i][1] + grid[i][2];
            int colSum = grid[0][i] + grid[1][i] + grid[2][i];
            if (rowSum != 15 || colSum != 15) return false;
        }

        if (grid[0][0] + grid[1][1] + grid[2][2] != 15) return false;
        if (grid[0][2] + grid[1][1] + grid[2][0] != 15) return false;
        return true;
    }
}