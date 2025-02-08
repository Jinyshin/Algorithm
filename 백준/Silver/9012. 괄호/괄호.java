import java.util.*;

public class Main {
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < t; i++) {
            Stack<Character> stack = new Stack<>();
            boolean answer = true;
            String paran = sc.nextLine();
            for (char c : paran.toCharArray()) {
                if (c == '(') stack.push(c);
                else {
                    if (stack.isEmpty()) {
                        answer = false;
                        break;
                    } else stack.pop();
                }
            }
            
            if (!stack.isEmpty()) {
                answer = false;
            }
            
            if (answer) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

/*
answer = true
()총문자열 길이만큼 반복
    ( -> push
    if ) 
        if stack empty -> break, answer = false
        else continue
(가 남아있으면 (!empty)
    answer = false
answer 값에 따라 출력
*/