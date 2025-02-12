import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String[] c : clothes) {
            map.putIfAbsent(c[1], new ArrayList<>()); // 의상 종류(key)가 없으면 새로운 리스트 생성
            map.get(c[1]).add(c[0]); // 해당 의상 종류 리스트에 의상 이름 추가
        }
        
        int answer = 1;        
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            int count = entry.getValue().size();
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}

/*
종류별 최대 1의상 착용가능, 최소 1개이상은 입음
서로 다른 옷 조합의 개수를 return

- clothes -> 해시맵 저장
- 각 맵별 원소수 + 1 끼리 곱하고 - 1

*/