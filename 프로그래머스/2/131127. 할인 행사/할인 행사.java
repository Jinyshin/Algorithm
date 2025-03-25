import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int maxIndex = discount.length - 10 + 1;
        int answer = 0;
        for(int i = 0; i < maxIndex; i++) {
            Map<String, Integer> map = new HashMap<>();
            for(int j = 0; j < 10; j++) {
                String key = discount[i+j];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            
            boolean canJoin = true;
            for (int k = 0; k < want.length; k++) {
                String targetKey = want[k];
                int targetVal = number[k];
                if (map.getOrDefault(targetKey, 0) < targetVal) {
                    canJoin = false;
                    break;
                }
            }
            if (canJoin) answer++;
        }
        
        return answer;
    }
}

/*
- discount의 첫째원소부터..전체원소길이-10+1까지 반복: 
    - 10칸씩 끝까지 순회하면서 순회할때마다 해시맵 만들기
        제품명 : 수량
    - want 배열의 원소들 인덱스로 접근해 돌면서 number값 <= 수량 인지 비교: 중간에 조건 만족 안하면 break
    - want 배열의 모든 원소들이 해당 조건 만족하면 -> answer++;

시간복잡도
- 해시맵 만드는데 O(n), n 최대 10^5 -> 가능

주의사항
- map.get(...)은 키가 없으면 null이기 때문에, 반드시 getOrDefault(...)를 사용해야함(안그럼 NPE 터짐)
*/