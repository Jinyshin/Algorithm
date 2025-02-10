import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> cards = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            cards.offer(i);
        }
        boolean isDiscard = true;

        while(cards.size() > 1) {
            if(isDiscard){
                cards.poll();
                isDiscard = false;
            } else {
                int card = cards.poll();
                cards.offer(card);
                isDiscard = true;
            }
        }

        System.out.println(cards.poll());
    }
}

/*
- 조건, 구할거 확인
1~N까지 특정 동작 반복: O(N) 해결 가능
- 자료구조 결정
큐
- 의사코드 설계
버리냐, 뒤로 보내냐 두개의 상태를 구분하는 boolean 변수 활용
- 시간복잡도 계산
*/