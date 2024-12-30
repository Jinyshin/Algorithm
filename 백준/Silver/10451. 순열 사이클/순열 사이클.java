import java.util.*;

public class Main {
    static int T, N;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            N = sc.nextInt();
            visited = new int[N + 1];
            int[] permutation = new int[N + 1]; 
            for (int i = 1; i <= N; i++) {
                permutation[i] = sc.nextInt();
            }
            countCycle(permutation);
        }
    }

    public static void countCycle(int[] permutation) {
        ArrayList<ArrayList<Integer>> pCycleList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> graph = new ArrayList<>();
            int key = i;
            if (visited[key] == 1) {
                continue;
            }
            while (!graph.contains(key)) {
                graph.add(key);
                key = permutation[key];
                visited[key] = 1;
            }
            pCycleList.add(graph);
        }
        System.out.println(pCycleList.size());
    }
}