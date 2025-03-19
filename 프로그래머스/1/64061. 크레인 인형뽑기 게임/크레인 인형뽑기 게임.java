import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        List<Stack<Integer>> boardList = new ArrayList<>();
        Stack<Integer> basket = new Stack<>();
        int answer = 0;
        
        // boardList 세로컬럼 초기화
        for(int i = 0; i < n; i++) {
            boardList.add(new Stack<>());
        }
        
        // 컬럼 기준으로 접근하고, 맨밑줄부터 push하기
        for (int j = n - 1; j >= 0; j--) {
            for (int i = n - 1; i >= 0; i--) {
                boardList.get(j).push(board[i][j]);
            }
        }
                
        for (int move : moves) {
            int target = move - 1;
            Stack<Integer> col = boardList.get(target);
            if (!col.isEmpty()) {
                // 실제 인형이어야 함
                int doll = 0;
                while (!col.isEmpty() && col.peek() == 0) {
                    col.pop();
                }
                doll = col.pop();
                if (!basket.isEmpty() && basket.peek() == doll) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(doll);
                }
            }
        }
        return answer;
    }
}

/*
게임화면 표현:
    lifo 구조로 인형 out -> 스택으로 표현하면 제거가 쉬울듯
    0은 빈칸, 숫자가 인형종류
바구니 표현: 스택, 인형의 종류(숫자)를 저장, 같으면 현재인형저장 안하고 pop
구하는 것: 터트려져 사라진 인형의 개수
*/