import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> daysQueue = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int progressLeft = 100 - progresses[i];         
            int days = (int) Math.ceil((double)progressLeft / speeds[i]);
            daysQueue.offer(days);
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        while(!daysQueue.isEmpty()) {
            int deployDay = daysQueue.poll(); // 배포기준일
            int count = 1; // 첫배포날에 배포되는 첫기능으로 초기화
            
            while(!daysQueue.isEmpty() && daysQueue.peek() <= deployDay) {
                daysQueue.poll();
                count++;
            }
            answerList.add(count);
        }
        
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}

/*
필요한 정보
- 각 기능마다 며칠의 작업분량이 남았는지 계산 -> 남은일수배열에 저장
int[] dayLeft = new int[progresses.length];

- 동시배포할작업 횟수 더해서 묶기
    - 남은일수배열 순회, 현재 배포되는 기능보다 오래걸리는 기능 나올때까지 묶는다.
*/