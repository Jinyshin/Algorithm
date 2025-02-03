import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // (priorities, 초기 위치)를 큐에 저장하고, 가장 큰 우선순위 비교를 위한 우선순위 큐를 별도로 저장
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i});
            pq.add(priorities[i]);
        }
        
        // 찾고자 하는 location값 == poll한 초기 위치가 같으면 끝
        int answer = 0; // 실행횟수
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int priority = curr[0];
            int index = curr[1];
            
            if (priority == pq.peek()) {
                answer++; // 최대 우선순위일때 실행가능 -> 횟수 증가
                pq.poll();
                
                if (index == location) {
                    return answer;
                }
            } else {
                // 현재 값이 최대우선순위 아님 -> 다시 큐 삽입
                queue.offer(curr);
            }
        }
        return answer;
    }
}

/*
특정 프로세스가 몇번째로 실행되는지 알아내기
- 일단 꺼내고
- 뒤 프로세스중에우선순위 확인하고
    - 더높은게 있으면다시 넣고 높은거함. -> 다시 넣는다는게 큐의 뒤에 삽입한다는 것
    - 없으면 그거 실행함
- 한번 실행한 프로세스는 종료됨

priorities: 4,3,2,1
특정 location의 프로세스가 몇번째로 실행되는지. location은 0 based index임.
*/