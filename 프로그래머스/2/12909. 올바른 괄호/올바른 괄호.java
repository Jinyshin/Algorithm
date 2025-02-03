import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false; // )가 먼저 나온 경우
                stack.pop(); // push는 ( 만 하고 있으므로 '('인지에 대한 검사는 안해도 됨.
            }
        }
        
        return stack.isEmpty();
    }
}

/*
스택에 넣고 시작하는게 아니라, 스택을 임시 저장소로 활용한다.
*/