import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Integer> numbers;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numbers.add(i + 1);
        }
        seq = new int[M];

        backtracking(numbers, 0);
        System.out.println(sb.toString());

    }

    static void backtracking(List<Integer> numbers, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int j = 0; j < numbers.size(); j++) {
            seq[depth] = numbers.get(j);
            // 현재 인덱스 j 이후의 원소들만 포함한 리스트 생성
            List<Integer> nextNumbers = new ArrayList<>(numbers.subList(j + 1, numbers.size()));
            backtracking(nextNumbers, depth + 1);
        }
    }

}