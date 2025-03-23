import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 참가자 목록과 완주자 목록 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 완주하지 못한 참가자 찾기
        for (int i = 0; i < completion.length; i++) {
            // 동명이인이 아닌 경우
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        
        // 완주하지 못한 참가자가 맨 마지막에 있는 경우 처리
        return participant[participant.length - 1];
    }
}

// 비효율적인 코드
// import java.util.ArrayList;

// class Solution {
//     public String solution(String[] participant, String[] completion) {
//         ArrayList<String> listPP = new ArrayList<>();
//         for (String p: participant) {
//             listPP.add(p);
//         }
        
//         for (String c: completion) {
//             listPP.remove(String.valueOf(c));
//         }
        
//         return listPP.get(0);
//     }
// }
