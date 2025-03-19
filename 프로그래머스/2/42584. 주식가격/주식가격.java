import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        int time = 0;
        for (int i = 0; i < prices.length; i++ ){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = time - index;
            }
            stack.push(i);
            time++;
        }
                        
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = time - index - 1;
        }
        
        return answer;
    }
}

/*
각 초별 가격이 떨어지지 않은 기간 구하기 -> 각 초-1을 인덱스로 가지는 배열 선언
가격이 떨어진 순간이 중요함. 일단 떨어지면 다음에 그 값이 또 필요하지 않음.

가격 오르면 스택 push
가격이 떨어지면 stack pop, 인덱스값 update: 현재 지나온 시간 - 각 초
1
1 2
1 2 3
1 2  
1 2 2
1 2 2 3

추가 테스트
1 3 6 2 3 1

1
1 3
1 3 6
1 3 -> 이때 3초 시점 기록: 1 = 4 - 3
1 -> 2초 시점 기록: 2 = 4 - 2
이때는 시간 지나지 않음.
1 2
1 2 3
1 2 -> 4초 기록: 2 = 6 - 4

-> 스택에 prices의 인덱스값을 저장해야 마지막에 '기간'을 구할 수 있음.

*/