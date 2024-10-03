import java.util.Arrays;

/*
- 숫자들을 합치고 크기 비교를 하기 위해 숫자 배열을 문자열 배열로 바꿈
- 퀵소트 수행
- 정렬된 결과를 이어 붙여서 최종적인 결과를 반환한다.
- 모든 숫자들이 0인 경우를 예외처리하기
*/

public class Solution {
    
    public static String solution(int[] numbers) {
        // 숫자 배열을 문자열 배열로 변환
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        quickSort(strNumbers, 0, strNumbers.length - 1);
        
        StringBuilder result = new StringBuilder();
        for (String num : strNumbers) {
            result.append(num);
        }
        
        // "000..." -> "0" 반환
        if (result.toString().startsWith("0")) {
            return "0";
        }
        
        return result.toString();
    }
    
    private static void quickSort(String[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }
    
    // 피벗 기준으로 합친 문자열의 크기 비교(ab VS ba)
    private static int partition(String[] arr, int left, int right) {
        String pivot = arr[right];
        int i = left;
        int j = right - 1;

        while (i <= j) {
            // i는 피벗보다 작은 값을 찾을 때까지 오른쪽으로 이동
            while ((arr[i] + pivot).compareTo(pivot + arr[i]) > 0) {
                i++;
            }

            // j는 피벗보다 큰 값을 찾을 때까지 왼쪽으로 이동
            while (i <= j && (arr[j] + pivot).compareTo(pivot + arr[j]) <= 0) {
                j--;
            }

            // 엇갈리지 않았다면 교환
            if (i < j) {
                swap(arr, i, j);
            }
        }

        // 피벗을 i 위치로 교환하여 피벗이 올바른 위치에 오게 함
        swap(arr, i, right);
        return i;
    }

    
    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
