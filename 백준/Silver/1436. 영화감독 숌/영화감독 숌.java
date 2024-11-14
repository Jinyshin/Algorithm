/*
666처럼 6이 적어도 3개 이상 들어가는 N번째 수를 찾는다.
 */

import java.util.Scanner;

public class Main {
    static int N;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int number = 666;

        while (true) {
            if (String.valueOf(number).contains("666")) {
                count++;
            }

            if (count == N) {
                System.out.println(number);
                break;
            }

            number++;
        }
    }
}