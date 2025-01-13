import java.io.*;

public class Main {
    static String minNewStr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        minNewStr = "~";
        int n = word.length();
        for (int i = 1; i <= n-2; i++){
            for(int j = i+1; j <= n-1; j++ ){
                String s1 = word.substring(0,i);
                String s2 = word.substring(i,j);
                String s3 = word.substring(j,n);
                String[] words = new String[] {s1, s2, s3};
                makeNew(words);
            }
        }
        System.out.println(minNewStr);
    }
    public static void makeNew(String[] words){
        StringBuilder sb = new StringBuilder();
        for (String word: words) {
            sb.append(new StringBuilder(word).reverse());
        }
        String newStr = sb.toString();
        if (minNewStr.compareTo(newStr) > 0) minNewStr = newStr;
    }
}