import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

/*
A: 8,1,7,3,1
B: 3,6,1
가능한 (A,B) 중에서 A>B인 쌍이 몇개인지 구하기
(A,B)는 N*M개. N*M의 최댓값은 2만 * 2만 == 4*10^8 -> 간당하게 가능//이 아니라 시간 초과. 10^8 나오면 일단 방법을 바꿔야 함.
*/

public class Main {
    public static void main(String[] args) throws IOException{
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            // 테케별 입력받기
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);
            int count = 0;

            for (int a: A) {
                int left = 0;
                int right = B.length;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if(B[mid] < a) {
                        left = mid + 1;
                    }
                    else {
                        right = mid;
                    }
                }
                count += left;
            }

            // 끝에 출력
            System.out.println(count);
        }
    }
}