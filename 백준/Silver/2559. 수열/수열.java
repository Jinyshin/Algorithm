import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];
        st  = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int max;
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += numbers[i];
        }
        max = curr;
        for (int i = 0; i < n-k; i++) {
            curr -= numbers[i];
            curr += numbers[i+k];
            max = Math.max(max, curr);
        }

        System.out.println(max);
    }
}

/*
10 5 예시
int max
for int i : 0~n-k
    [0] ~ [4] 까지 합 구하기 -> 처음이니까 Max 초기화
    맨앞원소 빼고 다음원소 더해서 [1] ~ [5] 구하기 = curr, max랑 비교하기

시간복잡도 O(n), 가능
*/