import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answerList = new ArrayList<>();
        answerList.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                answerList.add(arr[i]);
            }
        }
        
        int[] answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}