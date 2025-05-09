import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();
        int totalTime = 0;
        
        for (String city : cities) {
            String curr = city.toLowerCase();

            if (cacheSize == 0) {
                totalTime += 5;
                continue;
            }
            if (queue.contains(curr)) {
                queue.remove(curr);
                queue.add(curr);
                totalTime += 1;
            } else {
                if (queue.size() == cacheSize) {
                    queue.poll();
                }
                queue.add(curr);
                totalTime += 5;
            }
        }
        return totalTime;
    }
}

/*
주의할 제약조건
- 도시이름은 영문자이고, 대소문자 구분하지 않음.
- 캐시 교체 알고리즘이 LRU임
    - => 캐시 가득 찼을 때, 가장 오랫동안 사용되지 않은 데이터 제거
    - 그런데 주의할점: 최근에 접근한 요소는 캐시의 가장 최신 위치로 이동시켜줘야함!!!
- 캐시 크기가 0인 경우는 큐에 넣거나 뺄 수 없으니까 따로 처리해줘야함..
*/