import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] matryo = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            matryo[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(matryo);
        
        PriorityQueue<Integer> matryoQ = new PriorityQueue<>();
        
        for (int size : matryo) {
            if (!matryoQ.isEmpty() && matryoQ.peek() < size) matryoQ.poll();
            matryoQ.add(size);
        }
        System.out.println(matryoQ.size());
    }
}

/*
- 마트료 int[] 오름차순 정렬
- 각 마트료 순회 -> 우선순위 큐 활용해서 마트료 합치든(제거) 추가하든 하기
*/