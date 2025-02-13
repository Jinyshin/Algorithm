import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] postfix = br.readLine().toCharArray();
        Stack<Double> stack = new Stack<>();

        HashMap<Character, Double> map = new HashMap<>();
        for (char c : postfix) { // 여기를 틀렸었음. 그냥 숫자길이가 아니라, postfix 의 길이만큼 순회해야한다고!
            if (c != '+' && c != '-' && c != '/' && c != '*' && !map.containsKey(c)) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int operand = Integer.parseInt(st.nextToken());
                map.put(c, (double) operand); // 이거 맞나?
            }
        }

        for(char ch: postfix) {
            if (ch != '+' && ch != '-' && ch != '/' && ch != '*') {
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

        System.out.printf("%.2f\n", stack.pop());  // 소수점 둘째 자리까지 출력
        br.close();
    }
}

/*
- int N, toCharArray로 배열 저장
- for 문 -> hashMap 만들어 저장 ex) A:1, B:2, C:3, D:4, E:5
- Stack<Double> 활용해서 연산 진행, 후위표기식 끝까지 반복
- 반복문 종료 후 stack.pop() 출력
*/