import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();

        List<Integer> results = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int index = 0;
        while(!list.isEmpty()) {
            index = (index + K - 1) % list.size();
            int removed = list.remove(index);
            results.add(removed);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < results.size(); i++) {
            sb.append(results.get(i));
            if (i < results.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}