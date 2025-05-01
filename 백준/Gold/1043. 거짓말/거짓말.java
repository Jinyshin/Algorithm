import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int m = Integer.parseInt(st.nextToken()); // 파티 수

        // 진실을 아는 사람들
        Set<Integer> truePpl = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        int trueNum = Integer.parseInt(st.nextToken());
        for (int i = 0; i < trueNum; i++) {
            truePpl.add(Integer.parseInt(st.nextToken()));
        }

        // 파티 목록
        List<int[]> partyList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pplCount = Integer.parseInt(st.nextToken());
            int[] ppl = new int[pplCount];
            for (int j = 0; j < pplCount; j++) {
                ppl[j] = Integer.parseInt(st.nextToken());
            }
            partyList.add(ppl);
        }

        // 진실 전파
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int[] party : partyList) {
                boolean hasTruePpl = false;
                for (int person : party) {
                    if (truePpl.contains(person)) {
                        hasTruePpl = true;
                        break;
                    }
                }

                if (hasTruePpl) {
                    for (int person : party) {
                        if (truePpl.add(person)) {
                            changed = true;
                        }
                    }
                }
            }
        }

        // 과장 가능한 파티 수 세기
        int result = 0;
        for (int[] party : partyList) {
            boolean canLie = true;
            for (int person : party) {
                if (truePpl.contains(person)) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) result++;
        }

        System.out.println(result);
    }
}