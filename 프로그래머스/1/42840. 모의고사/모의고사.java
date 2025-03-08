import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public static final int[][] RULES = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5},
    };
    public int[] solution(int[] answers) {
        int[] corrects = new int[3];
        int max = 0;
        
        // 각 수포자별로 정답 개수 세기
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            for (int person = 0; person < 3; person++) {
                int supoAnswer = getSupoAnswer(person, i);
                if (answer == supoAnswer) {
                    if (++corrects[person] > max) max = corrects[person];
                }
            }
        }
        
        final int finalMax = max;
        return IntStream.range(0, 3)
            .filter(i -> corrects[i] == finalMax)
            .map(i -> i + 1)
            .toArray();
    }
    
    private int getSupoAnswer(int person, int problem) {
        int[] rule = RULES[person];
        int index = problem % rule.length;
        return rule[index];
    }
}

/*
각 수포자별로 정답수 세는 횟수 <= 3 * 10^4 -> 1초 가능
*/