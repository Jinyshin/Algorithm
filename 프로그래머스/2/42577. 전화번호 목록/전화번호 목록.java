import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String number : phone_book) {
            map.put(number, 1);
        }
        
        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                String prefix = number.substring(0, i);
                if (map.containsKey(prefix)) return false;
            }
        }
        return true;
    }
}

/*
해시맵 활용해서 풀기

각 전화번호부를 해시맵에 저장
각 전화번호로 만들 수 있는 모든 접두어들이 해시맵에 존재하는지 확인
    1235 -> 1, 12, 123 확인 -> 존재하면 false
*/