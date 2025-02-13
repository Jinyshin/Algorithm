import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] postfix = br.readLine().toCharArray();
        Stack<Double> stack = new Stack<>();
        Set<Character> operators = Set.of('+', '-', '*', '/');

        HashMap<Character, Double> map = new HashMap<>();
        for (char c : postfix) {
            // 불필요한 StringTokenizer 제거
            if (!operators.contains(c) && !map.containsKey(c)) {
                map.put(c, Double.parseDouble(br.readLine()));
            }
        }

        for(char ch: postfix) {
            if (!operators.contains(ch)) {
                stack.push(map.get(ch));
            } else {
                double b = stack.pop();
                double a = stack.pop();

                switch (ch) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }

        System.out.printf("%.2f\n", stack.pop());
        br.close();
    }
}

/*
- int N, toCharArray로 배열 저장
- for 문 -> hashMap 만들어 저장 ex) A:1, B:2, C:3, D:4, E:5
- Stack<Double> 활용해서 연산 진행, 후위표기식 끝까지 반복
- 반복문 종료 후 stack.pop() 출력
*/
