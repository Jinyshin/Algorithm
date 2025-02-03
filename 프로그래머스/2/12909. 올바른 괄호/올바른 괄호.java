import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else if (stack.peek() == '(') {
                    stack.pop();
                } 
            }
        }
        
        if (!stack.isEmpty()) answer = false;
        
        return answer;
    }
}

/*
(((()))) -> true
))) -> false
((() -> false

스택에 넣고 시작하는게 아니라, 스택을 임시 저장소로 활용
*/