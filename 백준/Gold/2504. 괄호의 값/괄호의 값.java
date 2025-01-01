import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(calculateValue(input));
    }
    public static int calculateValue(String input) {
        int result = 0;
        int temp = 1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(c);
                temp *= 2;
            } else if (c == '[') {
                stack.push(c);
                temp *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return 0;
                if (input.charAt(i - 1) == '(') result += temp;
                stack.pop();
                temp /= 2;
            }else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return 0;
                if (input.charAt(i - 1) == '[') result += temp;
                stack.pop();
                temp /= 3;
            }
        }
        // 모든 괄호가 짝지어졌는지 확인
        if (!stack.isEmpty()) return 0;
        
        return result;
    }
}