import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> uidToNick = new HashMap<>();
        List<String[]> result = new ArrayList<>();
        
        for (String r : record) {
            String[] rList = r.split(" ");
            String action = rList[0];
            String uid = rList[1];
            if (action.equals("Enter") || action.equals("Change")) {
                String nick = rList[2];
                uidToNick.put(uid, nick);
            }
            if (action.equals("Enter") || action.equals("Leave")) {
                String[] curr = {uid, action};
                result.add(curr);
            }
        }
        
        String[] answer = new String[result.size()];
        int i = 0;
        for (String[] r : result) {
            StringBuilder sb = new StringBuilder();
            String nick = uidToNick.get(r[0]);
            if (r[1].equals("Enter")) {
                sb.append(nick);
                sb.append("님이 들어왔습니다.");
                answer[i] = sb.toString();
            } else {
                sb.append(nick);
                sb.append("님이 나갔습니다.");
                answer[i] = sb.toString();
            }
            i++;
        }
        
        return answer;
    }
}

/*
- 사람 입장 / 퇴장 메시지 출력
- 사람 간의 중복 닉네임 허용
- 닉네임 변경
    - 채팅방 퇴장 -> 새 닉네임 재입장
        - 재입장 시 퇴장 이전에 변경한 닉네임도 전부 변경됨
    - 채팅방 입장한 채로 -> 닉네임 변경
        - 기존 채팅방에 출력되어있던 메시지 닉네임 전부 변경
        
- input: 채팅방 출입, 닉네임 변경 기록 문자열 배열 record
- output: 모든 기록 처리 후 최종적으로 방 개설자가 보게 되는 메시지를 문자열 배열 형태로 return

for(String r : record):
    명령어 파싱 진행
    if Enter:
        if (들어온 적 있는 경우):
            바뀌었을수도있는 닉네임 설정
            for (String r : result):
                if r uid == 현재 uid:
                    닉네임 = 현재 닉네임
        add "[닉네임]님이 들어왔습니다." to result
    else if Leave:
        add "[닉네임]님이 나갔습니다." to result
    else if Change:
        for (String r : result):
            if r uid == 현재 uid:
                닉네임 = 현재 닉네임

시간복잡도
    - 최악의 경우 10^5 * 10^5 = 10^10

---

- Map<String, String>: uid -> 닉네임 매핑
- List<String[]>: uid, Enter/Change/Leave
- 최종으로 매핑해서 출력

for each record:
    Enter/Change → UID의 닉네임 Map 업데이트
    Enter/Leave → 결과 리스트에  (UID, 명령) 저장
결과 리스트를 순회: UID->닉네임 변환해서 메시지 완성

시간복잡도
    - 최악의 경우 10^5 (O(n))
    
=> 한 번에 result 문장을 만들겠다는 생각 X, 변동 가능성이 있는 것만 따로 떼어서 생각하기
*/