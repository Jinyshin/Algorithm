import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> s = new HashSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                s.add(sum);
            }
        }
        
        int[] answer = s.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

/*
배열에 오름차순으로 담기 -> set 구조에 담고 -> 배열로 변환 -> 정렬
- 100개의 수 n^2 == 10^4 -> 가능
- 순열 구하기
    for i in num 길이:
        for j : i~num 길이:
*/