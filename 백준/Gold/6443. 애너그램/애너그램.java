import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String[] words;
    static char[] charArray;
    static char[] anagram; // anagram단어이면 -> sb에 추가
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            int len = words[i].length();
            charArray = words[i].toCharArray();
            Arrays.sort(charArray);
            anagram = new char[len];
            isVisited = new boolean[len];

            backtracking(charArray, len, 0);
        }

        System.out.println(sb.toString());
    }

    static void backtracking(char[] charArray, int len, int depth) {
        // 종료조건: 깊이 == len
        if (depth == len) {
            for (int i = 0; i < len; i++) {
                // anagram은 ['a', 'c', 'b']와 같은 char 배열이다.
                sb.append(anagram[i]);
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < len; i++) {
            // 중복 방지: 같은 문자가 연속으로 나올 때, 이전 문자가 선택되지 않은 경우 스킵
            if (i > 0 && charArray[i] == charArray[i - 1] && !isVisited[i - 1]) {
                continue;
            }

            if (!isVisited[i]) {
                anagram[depth] = charArray[i];
                isVisited[i] = true;
                backtracking(charArray, len, depth + 1);
                isVisited[i] = false;
            }
        }
    }
}