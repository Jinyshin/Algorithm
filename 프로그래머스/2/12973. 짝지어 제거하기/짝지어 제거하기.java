import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
                continue;
            } 
            if (stack.peek() == c) stack.pop();
        }
        
        if (stack.isEmpty()) answer = 1;
        else answer = 0;

        return answer;
    }
}

/*
1. 두개 붙은짝찾기 -> 2. 둘 제거, 앞뒤 이어붙이기
스택을 임시 저장소로 활용
s에서 하나의 char씩 확인
    if stack is empty || stack.peek() != 현재 char
        push
        continue
    if stack.peek() == 현재 char
        stack.pop
[ 예제 ]
b
ba
b

a

-> s끝 && 스택 is empty => 1

c
cd
cdc
cdcd
-> s끝 but 스택 is not empty => 0

추가 케이스 생각
eidfggfdddie

e
ei
eid
eidf
eidfg
eidf
eid
ei
eid
ei
e

=> 1
*/