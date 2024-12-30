import java.util.*;

public class Main {
        static int T, N;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        StringBuilder result = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = sc.nextInt();
            visited = new int[N + 1];
            int[] permutation = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                permutation[i] = sc.nextInt();
            }
            result.append(countCycle(permutation)).append("\n");
        }
        System.out.print(result);
    }

    public static int countCycle(int[] permutation) {
        int cycleCount = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 1) {
                continue;
            }
            int key = i;
            while (visited[key] == 0) {
                visited[key] = 1;
                key = permutation[key];
            }
            cycleCount++;
        }
        return cycleCount;
    }
}