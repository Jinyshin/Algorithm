import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[][] people = new String[n][4];
        for (int i = 0; i < n; i++) {
            String[] info = sc.nextLine().split(" ");
            for (int j = 0; j < 4; j++) {
                people[i][j] = info[j];
            }
        }

        // 가장 나이 적은 사람 구하기
        String[] youngest = people[0];
        for (int i = 1; i < n; i++) {
            if (isYounger(people[i], youngest)) {
                youngest = people[i];
            }
        }

        // 가장 나이 많은 사람 구하기
        String[] oldest = people[0];
        for (int i = 1; i < n; i++) {
            if (isOlder(people[i], oldest)) {
                oldest = people[i];
            }
        }

        System.out.println(youngest[0]);
        System.out.println(oldest[0]);
    }

    // 더 어린지 비교하는 함수
    private static boolean isYounger(String[] person1, String[] person2) {
        int year1 = Integer.parseInt(person1[3]);
        int year2 = Integer.parseInt(person2[3]);
        if (year1 > year2) return true;
        if (year1 < year2) return false;

        int month1 = Integer.parseInt(person1[2]);
        int month2 = Integer.parseInt(person2[2]);
        if (month1 > month2) return true;
        if (month1 < month2) return false;

        int day1 = Integer.parseInt(person1[1]);
        int day2 = Integer.parseInt(person2[1]);
        return day1 > day2;
    }

    // 더 나이가 많은지 비교하는 함수
    private static boolean isOlder(String[] person1, String[] person2) {
        int year1 = Integer.parseInt(person1[3]);
        int year2 = Integer.parseInt(person2[3]);
        if (year1 < year2) return true;
        if (year1 > year2) return false;

        int month1 = Integer.parseInt(person1[2]);
        int month2 = Integer.parseInt(person2[2]);
        if (month1 < month2) return true;
        if (month1 > month2) return false;

        int day1 = Integer.parseInt(person1[1]);
        int day2 = Integer.parseInt(person2[1]);
        return day1 < day2;
    }
}
