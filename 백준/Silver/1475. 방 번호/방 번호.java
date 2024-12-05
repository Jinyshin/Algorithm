/*
방 번호
0-9숫자가 하나씩. 6,9만 예외. 9 2개 == 6 2개 == 6,9 1개씩
ex) 예제1: 0,0,,,0,4 예제3: 0,1,1,1,0,1,1,0,0,0  0,0,0,0,0,0,2,2,3,1
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] n = sc.nextLine().toCharArray(); // 방 번호 배열

        // 0-9 숫자 개수 세기
        int[] count = new int[10];
        for (char number : n) {
            count[number - '0']++;
        }

        // 6,9 등장횟수 합산 처리
        count[6] = (count[6] + count[9] + 1) / 2;
        count[9] = count[6];

        // 가장 많이 사용된 숫자의 등장횟수 구하기
        int max = 0;
        for (int i = 0; i < 9; i++) {
            max = Math.max(max, count[i]);
        }
        System.out.println(max);
    }
}
