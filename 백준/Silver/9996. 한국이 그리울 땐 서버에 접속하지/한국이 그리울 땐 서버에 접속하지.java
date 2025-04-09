import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String pattern = sc.next();
        int starIdx = pattern.indexOf('*');
        int prefixLen = starIdx;
        int suffixLen = pattern.length() - starIdx - 1;

        for (int t = 0; t < N; t++) {
            String fileName = sc.next();
            int fileLen = fileName.length();
            boolean isSame = true;
            
            if (fileLen < prefixLen + suffixLen) {
                isSame = false;
            } else {
                for (int i = 0; i < prefixLen; i++) {
                    if (fileName.charAt(i) != pattern.charAt(i)) {
                        isSame = false;
                        break;
                    }
                }
                for (int i = 0; i < suffixLen; i++) {
                    if (fileName.charAt(fileLen - suffixLen + i) != pattern.charAt(pattern.length() - suffixLen + i)) {
                        isSame = false;
                        break;
                    }
                }
            }
            System.out.println(isSame ? "DA" : "NE");
        }
    }
}