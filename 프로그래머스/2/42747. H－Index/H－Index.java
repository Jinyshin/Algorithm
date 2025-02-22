import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int hindex = 0;

        for (int i = 0; i < n; i++) {
            int h = n - i; // 현재 가능한 h-index 값
            if (citations[i] >= h) {
                hindex = h; // hindex 갱신
                break;
            }
        }
        
        return hindex;
    }
}

/*
test:
    1,1,1,1,1 : 1
    10,1,4,2 -> 1,2,4,10 : 2
    10000, 10000, 10000, 10000 : 4
    1, 5, 만, 만: 3

citations.length <= 1000, h-index <= 10^4

3 0 6 1 5 -> 0 1 3 5 6
정렬 이후 하나씩 확인
    인덱스 i 기준, citations[i] >= i~length-1
        hindex 갱신
        break
*/