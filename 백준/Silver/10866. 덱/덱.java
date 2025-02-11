import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
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
                case "pop_front" -> sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                case "pop_back" -> sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                case "size" -> sb.append(deque.size()).append("\n");
                case "empty" -> sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                case "front" -> sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                case "back" -> sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
