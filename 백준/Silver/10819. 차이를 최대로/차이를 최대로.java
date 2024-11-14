import java.util.Scanner;

public class Main {
    static int N;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[N];
        String[] line = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        // 배열의 모든 순열을 생성하고 최댓값 계산
        permutation(arr, 0);

        // 최댓값 출력
        System.out.println(max);
    }

    public static void permutation(int[] arr, int depth) {
        if (depth == N) {
            max = Math.max(max, calculate(arr));
        }

        for (int i = depth; i < N; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1);
            swap(arr, depth, i);
        }

    }

    private static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public static int calculate(int[] arr) {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }
        return sum;
    }
}