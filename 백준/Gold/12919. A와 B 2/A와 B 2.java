import java.io.*;

public class Main {
    static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        System.out.println(canConvert(T) ? 1 : 0);
    }

    public static boolean canConvert(String current) {
        // 만약 현재 문자열 길이가 S와 같다면 더 이상 진행 불가능
        if (current.length() == S.length()) {
            return current.equals(S);
        }

        boolean result = false;

        // T에서 시작해서 S로 변환하는 방식으로 생각
        // 뒤에서 A를 빼거나 뒤에서 B를 빼고 뒤집기
        if (current.charAt(current.length() - 1) == 'A') {
            result = canConvert(current.substring(0, current.length() - 1));
        }

        if (!result && current.charAt(0) == 'B') {
            String reversed = new StringBuilder(current.substring(1)).reverse().toString();
            result = canConvert(reversed);
        }

        return result;
    }
}


/*
S + A
reverse(S + B)

만약 길이가 T랑 같아지면, T랑 같은 문자열인지 비교한 후 맞으면 true, 아니면 false

- 변경: 경우가 너무 많아서 시간초과가 난다. 반대로 T->S를 만들어간다. 이렇게 하면 맨 끝에 올 수 있는 문자가 A또는 B뿐이고, 각각에서 해야하는 작업이 결정되어 있기 때문에 경우의 수가 훨씬 줄어든다.
 */