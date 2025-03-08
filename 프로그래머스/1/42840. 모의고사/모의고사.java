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
        List<Integer> topScorers = new ArrayList<>();
        
        // 각 수포자별로 정답 개수 세기
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            for (int person = 0; person < 3; person++) {
                if (answer == RULES[person][i % RULES[person].length]) {
                    corrects[person]++;
                }
            }
        }
        
        max = Arrays.stream(corrects).max().getAsInt();
        // max = Math.max(corrects[0], Math.max(corrects[1], corrects[2]));
        
        for (int i = 0; i < 3; i++) {
            if (corrects[i] == max) {
                topScorers.add(i + 1);
            }
        }
        
        return topScorers.stream().mapToInt(Integer::intValue).toArray();
        
        // final int finalMax = max;
        // return IntStream.range(0, 3)
        //     .filter(i -> corrects[i] == finalMax)
        //     .map(i -> i + 1)
        //     .toArray();
    }
}

/*
각 수포자별로 정답수 세는 횟수 <= 3 * 10^4 -> 1초 가능

--
최적화

- RULES[person][i % RULES[person].length] 를 사용하여 불필요한 메서드 제거
- 최댓값을 위한 변수를 2개씩 쓰지 않고, 반복문 로직 이후 한번에 구하도록 변경
*/