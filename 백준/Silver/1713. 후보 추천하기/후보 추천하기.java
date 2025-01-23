/*
- 사진틀 관리 ArrayList<int[]> pictures; 학생 번호, 추천횟수 배열을 저장하는 리스트
- 최대 추천횟수가 1000 이므로, 시간복잡도는 1000

// 기존 추천인이라면 -> 추천횟수 증가
// 기존 추천인이 아니고, 추천인 명수 < N -> 사진틀에 추가
// 기존 추천인이 아니고, 추천인 명수 >= N -> 사진틀중 하나 삭제 후 현재 학생 추가
// 삭제 로직 구현 시, 1. 추천인 명수, 2. 추천된 시기 고려
*/
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<int[]> pictures = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            int student = Integer.parseInt(st.nextToken());
            boolean isExisting = false;
            for (int[] picture: pictures) {
                if (picture[0] == student) {
                    picture[1]++;
                    isExisting = true;
                    break;
                }
            }
            if(!isExisting) {
                if (pictures.size() < N) {
                    pictures.add(new int[]{student, 1});
                }
                else {
                    int minIdx = 0;
                    for (int j = 0; j < N; j++) {
                        if (pictures.get(j)[1] < pictures.get(minIdx)[1] || (pictures.get(j)[1] == pictures.get(minIdx)[1] && j < minIdx)) {
                            minIdx = j;
                        }
                    }
                    pictures.remove(minIdx);
                    pictures.add(new int[]{student, 1});
                }
            }

        }

        pictures.stream()
                .mapToInt(p -> p[0])
                .sorted()
                .forEach(student -> System.out.print(student + " "));
    }
}