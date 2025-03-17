import java.util.*;

class Solution {
    static Queue<Character> strList = new LinkedList<>();
    public int solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            strList.add(s.charAt(i));
        }
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isOk(strList)) answer++;
            spin(strList);
        }
        return answer;
    }
    
    public void spin(Queue<Character> strList) {
        char c = strList.poll();
        strList.offer(c);
    }
    
    public boolean isOk(Queue<Character> strList) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : strList) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else if (stack.isEmpty()) return false;
            else if (c == ')' && stack.pop() != '(') return false;
            else if (c == '}' && stack.pop() != '{') return false;
            else if (c == ']' && stack.pop() != '[') return false;
        }
        return stack.isEmpty();
    }
}

/*
s를 왼쪽으로 x칸 만큼 회전시켰을 때, s가 올바른 문자열이 되게 하는 x의 개수

- 정답개수 세는 변수
- for s의 길이:
    - 회전하는 함수
    - 올바른 문자열인지 검사하는 함수 호출

- 회전함수:
    linkedList에서 앞 빼고 뒤에 추가
- 올바른문자열 검사:
    검사용 스택 선언
    - char c: string 문자열 전체 순회:
        - c == (, {, [ -> Push
        - if stack.isEmpty: return false
        - if c == ) && stack.pop() != ( return false
        - },] 같은 로직 처리
*/