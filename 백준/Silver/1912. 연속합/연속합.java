import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int maxSum = sequence[0]; // 최댓값을 첫 번째 요소로 초기화
        int currentSum = sequence[0];

        for (int i = 1; i < n; i++) {
            currentSum = Math.max(sequence[i], currentSum + sequence[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}