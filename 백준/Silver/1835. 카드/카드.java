import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(N);
        for (int i = N - 1; i > 0; i--) {
            deque.addFirst(i);
            for (int j = 0; j < i; j++) {
                deque.addFirst(deque.removeLast());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer d : deque) {
            sb.append(d.toString()).append(" ");
        }

        System.out.println(sb);
    }
}