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