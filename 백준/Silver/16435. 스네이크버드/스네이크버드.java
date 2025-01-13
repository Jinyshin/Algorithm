import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // 최솟값 제거를 위한 우선순위 큐
        PriorityQueue<Integer> heights = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights.offer(Integer.parseInt(st.nextToken()));
        }

        while(!heights.isEmpty() && heights.peek() <= L) {
            heights.poll();
            L++;
        }

        System.out.println(L);
    }
}