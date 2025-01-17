import java.io.*;
import java.util.*;

/*
전체 가능한 숫자의 개수: 9P3, 9*8*7<500
-> 가능한 전체 숫자에서 안되는 것들을 제외해나감
*/

public class Main {
    public static Nums[] numbers;
    public static int count = 0;
    public static void main(String[] args) throws IOException{
        // 입력받고 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        numbers = new Nums[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            numbers[i] = new Nums(a,b,c);
        }

        // 가능한 모든 숫자를 정답으로 가정하고 반복
        for (int i = 123; i <= 987; i++) {
            int num1 = i / 100;
            int num2 = (i / 10) % 10;
            int num3 = i % 10;

            // 해당 안되는 숫자 필터링
            if (num1 * num2 * num3 == 0) continue;
            if (num1 == num2 || num2 == num3 || num1 == num3) continue;

            // 가능한 숫자인지 여부를 구분하는 변수
            boolean flag = true;

            // 모든 시도에 대해 반복하며 확인
            for (int j = 0; j < N; j++) {
                int stCount = 0;
                int ballCount = 0;

                Nums nums = numbers[j];
                int qnum = nums.trial; // 물어본 숫자
                int qnum1 = qnum / 100; // 물어본 숫자의 첫번째 자리
                int qnum2 = (qnum / 10) % 10;
                int qnum3 = qnum % 10;
                int astnum = nums.strike; // 물어본 숫자의 strike 개수
                int aballnum = nums.ball; // 물어본 숫자의 ball 개수

                if (qnum1 == num1) stCount++;
                if (qnum2 == num2) stCount++;
                if (qnum3 == num3) stCount++;

                if (num1 == qnum2 || num1 == qnum3) ballCount++;
                if (num2 == qnum1 || num2 == qnum3) ballCount++;
                if (num3 == qnum1 || num3 == qnum2) ballCount++;

                // 만약 st, ball 개수 일치 x -> 조건 불일치
                if (stCount != astnum || ballCount != aballnum) {
                    flag = false;
                    break;
                }
            }

            if (flag) count++;
        }
        System.out.println(count);
    }
}

class Nums {
    int trial;
    int strike;
    int ball;
    public Nums(int trial, int strike, int ball) {
        this.trial = trial;
        this.strike = strike;
        this.ball = ball;
    }
}