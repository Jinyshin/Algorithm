import java.util.*;

public class Main {
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        q.add(new int[]{n, 0});
        visited[n] = false;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int location = curr[0];
            int time = curr[1];

            if (location == k) {
                answer = time;
                break;
            }

            int[] next = new int[]{
                    location + 1, location - 1, location * 2
            };

            for (int i = 0; i < 3; i++) {
                int nextLocation = next[i];
                if (nextLocation >= 0 && nextLocation <= 100000 && !visited[nextLocation]) {
                    visited[nextLocation] = true;
                    q.add(new int[]{nextLocation, time + 1});
                }
            }
        }

        System.out.println(answer);
    }
}