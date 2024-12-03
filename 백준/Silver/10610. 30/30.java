/*
양수 N
N에 있는 숫자들을 섞어서 30의 배수가 되는 가장 큰 수를 만들어라

N은 최대 10^5개의 숫자로 구성되어있고, 0으로 시작하지 않음.
존재x -> -1출력
    N이 n자리 수라고 했을 때, 모든 경우의 수는 n!, 최대 10^5 = 10^5! -> 따라서 완전탐색으로는 불가능

30의 배수의 특징?
    30 = 2 * 3 * 5
    - 0으로 끝나야 함. -> 2,5의 배수
    - 자릿수의 합이 3의 배수여야 함. -> 3의 배수
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String biggestNumber;
    static String N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLine();
        if (canBeThirtyTimes(N)) {
            System.out.println(biggestNumber);
        } else{
            System.out.println(-1);
        }
    }

    static boolean canBeThirtyTimes(String number) {
        char[] nums = number.toCharArray();
        int sum = 0;
        for (char num : nums) {
            sum += num - '0';
        }
        // 30의 배수가 되는 수를 만들 수 없으면 false
        if (!number.contains("0") || sum % 3 != 0) {
            return false;
        }
        // 가능한 가장 큰 30의 배수 찾기
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder(new String(nums));
        biggestNumber = sb.reverse().toString();

        return true;
    }
}
