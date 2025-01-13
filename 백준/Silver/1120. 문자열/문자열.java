/*
B[i:i+M]과 A를 비교한 결과 -> 최소 다른 문자 개수 구하기.
*/
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int minDiff = A.length();
        for (int i = 0; i <= B.length() - A.length(); i++) {
            String subB = B.substring(i, i+A.length());
            int currDiff = calcDiff(A, subB);
            minDiff = Math.min(minDiff, currDiff);
        }

        System.out.println(minDiff);
    }

    public static int calcDiff(String A, String B) {
        int diff = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) diff++;
        }
        return diff;
    }
}