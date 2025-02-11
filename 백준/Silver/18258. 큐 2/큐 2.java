import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int operand = 0;
            if(st.hasMoreTokens()) {
                operand = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "push" -> queue.offer(operand);
                case "pop" -> sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
                case "size" -> sb.append(queue.size()).append("\n");
                case "empty" -> sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                case "front" -> sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                case "back" -> sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}