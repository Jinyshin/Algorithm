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
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += ((int) number.charAt(i));
        }
        // 30의 배수가 되는 수를 만들 수 없으면
        if (!number.contains("0") || sum % 3 != 0) {
            return false;
        }

        int[] numbers = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            numbers[i] = number.charAt(i) - '0';
        }
        Arrays.sort(numbers);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[numbers.length - 1 - i]);
        }
        biggestNumber = sb.toString();

        return true;
    }
}
