import java.util.Scanner;

public class Main {
    static StringBuilder result;
    static String board;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = sc.nextLine();
        result = new StringBuilder(board);
        
        // board가 'X'인 경우는 바로 실패
        if (board.equals("X")) {
            System.out.println("-1");
            return;
        }
        
        checkIsX(0);
        System.out.println(result.toString());
    }
    
    private static void checkIsX(int idx) {
        // 끝까지 도달했거나 이미 실패한 경우
        if (idx >= result.length() || result.toString().equals("-1")) {
            return;
        }
        
        // 현재 위치가 '.'이면 다음으로
        if (board.charAt(idx) == '.') {
            checkIsX(idx + 1);
            return;
        }
        
        // 현재 위치가 'X'일 때
        if (board.charAt(idx) == 'X') {
            // 다음 위치 체크 전에 범위 확인
            if (idx + 1 >= board.length()) {
                result.setLength(0);
                result.append("-1");
                return;
            }
            
            // X. 패턴 체크
            if (board.charAt(idx + 1) == '.') {
                result.setLength(0);
                result.append("-1");
                return;
            }
            
            // XX 패턴에서 끝나거나 XX. 패턴이면 BB로 덮기
            if (idx + 2 >= board.length() || board.charAt(idx + 2) == '.') {
                result.setCharAt(idx, 'B');
                result.setCharAt(idx + 1, 'B');
                if (idx + 2 < board.length()) {
                    checkIsX(idx + 2);
                }
                return;
            }
            
            // XXX 이상 패턴 체크
            if (board.charAt(idx + 2) == 'X') {
                // XXXX 패턴 체크 전에 범위 확인
                if (idx + 3 >= board.length()) {
                    result.setLength(0);
                    result.append("-1");
                    return;
                }
                
                if (board.charAt(idx + 3) == 'X') {
                    result.setCharAt(idx, 'A');
                    result.setCharAt(idx + 1, 'A');
                    result.setCharAt(idx + 2, 'A');
                    result.setCharAt(idx + 3, 'A');
                    checkIsX(idx + 4);
                } else {
                    result.setLength(0);
                    result.append("-1");
                }
            }
        }
    }
}