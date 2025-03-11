import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] reached = new int[N + 2];  // 스테이지 도달한 플레이어
        int[] failed = new int[N + 2];   // 스테이지에서 실패한 플레이어

        for (int stage : stages) {
            failed[stage]++;
        }

        int totalPlayers = stages.length;
        for (int i = 1; i <= N; i++) {
            reached[i] = totalPlayers;
            totalPlayers -= failed[i];
        }

        List<double[]> failureRates = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            double failureRate = (reached[i] == 0) ? 0 : (double) failed[i] / reached[i];
            failureRates.add(new double[]{failureRate, i});
        }

        failureRates.sort((a, b) -> {
            if (b[0] == a[0]) return (int) a[1] - (int) b[1];
            return Double.compare(b[0], a[0]); 
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) failureRates.get(i)[1];
        }

        return answer;
    }
}


/*
실패율이 높은 스테이지부터, 내림차순으로 스테이지 번호를 담은 배열 구하기
- 스테이지에 도달한 사람과 실패한 사람 수 계산
- 실패율 계산 및 저장 
    - List<double[]> failureRates 선언, (스테이지 번호, 실패율) 저장
- 실패율 기준으로 내림차순 정렬, 실패율이 같으면 스테이지 번호 오름차순 정렬
- 정렬된 결과 저장 후 리턴
*/