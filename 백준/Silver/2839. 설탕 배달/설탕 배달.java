/*
- N: 3 ~ 5000
- 최소 봉지 개수 or -1 출력

static int N;
int cnt = 0;
while (N > 0):
    if (N % 5 == 0): cnt += N / 5, break;
    else
        N -= 3;
        cnt ++;
    if (N < 0): cnt = -1;
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                cnt += N / 5;
                break;
            }
            else {
                N -= 3;
                cnt++;
            }
            if (N < 0) {
                cnt = -1;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
