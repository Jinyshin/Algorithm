import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        for (int s : scoville) {
            pq.offer(s);
        }
        int count = 0;
        while (true) {
            if (isMoreThanK(K)) break;
            if (pq.size() >= 2) {
                mix();
                count++;
            }
            else {
                count = -1;
                break;
            }
        }
        return count;
    }
    
    public boolean isMoreThanK(int K) {
        for (int num : pq) {
            if (num < K) return false;
        }
        return true;
    }
    
    public void mix() {
        int newS = pq.poll() + pq.poll() * 2;
        pq.offer(newS);
    }
}

/*
- 모든 음식 스코빌 지수 >= K 가 목표

- count = 0; 섞는 횟수
- mix; 섞는 함수
    - pq 자료구조 활용, 연산
- isMoreThanK; 모든음식 스코빌 지수가 K이상인지 확인하는 함수
*/