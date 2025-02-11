import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int operand = 0;
            if(st.hasMoreTokens()) {
                operand = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "push_front" -> deque.addFirst(operand);
                case "push_back" -> deque.addLast(operand);
                case "pop_front" -> System.out.println(deque.isEmpty() ? -1 : deque.pollFirst());
                case "pop_back" -> System.out.println(deque.isEmpty() ? -1 : deque.pollLast());
                case "size" -> System.out.println(deque.size());
                case "empty" -> System.out.println(deque.isEmpty() ? 1 : 0);
                case "front" -> System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
                case "back" -> System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
            }
        }
        br.close();
    }
}