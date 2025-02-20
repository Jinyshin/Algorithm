import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Queue<Map<String, Integer>> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String initial = st.nextToken();
            Integer num = Integer.parseInt(st.nextToken());
            q.offer(Map.of(initial, num)); // q에 학생 이니셜, 학번 삽입
        }
        
        while (q.size() > 1) {
            Map<String, Integer> frontStudent = q.poll();
            int num = frontStudent.values().iterator().next(); // 맨앞학생의 학번
            
            for (int i = 0; i < num - 1; i++) {
                Map<String, Integer> nextStudent = q.poll();
                q.offer(nextStudent);
            }
            
            Map<String, Integer> love = q.poll();
        }
        
        System.out.println(q.poll().keySet().iterator().next());
    }
}