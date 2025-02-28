import java.util.*;

public class Main {
    static int A, B, N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        N = sc.nextInt();
        M = sc.nextInt();

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        queue.add(new int[]{N, 0}); // 시작 위치, 이동 횟수
        visited[N] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int pos = curr[0];
            int count = curr[1];

            if (pos == M) {
                System.out.println(count);
                return;
            }

            int[] nextPositions = new int[] {
                    pos + 1, pos - 1,
                    pos + A, pos - A,
                    pos + B, pos - B,
                    pos * A, pos * B
            };

            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, count + 1});
                }
            }
        }

        int[] curr = queue.poll();
        int count = curr[1];
        System.out.println(count);
    }
}