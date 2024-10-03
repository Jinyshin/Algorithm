import java.util.*;

/*
다른 사람의 풀이 참고
*/

public class Solution {    
    public static String solution(int[] numbers) {
        String result = "";
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
                
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        
        result = sb.toString();
        if (result.startsWith("0")) {
            return "0";
        } else {
            return result;
        }
    }
}
