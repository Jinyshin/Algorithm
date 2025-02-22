import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, List<int[]>> songMap = new HashMap<>();
        // 재생횟수 합계 구하기 위한 Map
        Map<String, Integer> genrePlayCountMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];
            
            songMap.putIfAbsent(genre, new ArrayList<>());
            songMap.get(genre).add(new int[]{i, playCount});
            
            genrePlayCountMap.put(genre, genrePlayCountMap.getOrDefault(genre, 0) + playCount);
            
            // int[] playArr = new int[2];
            // playArr[0] = i;
            // playArr[1] = plays[i];
            // songMap.put(genre, playArr); 
            // 이렇게 저장하면 각 장르당 int[] 하나씩밖에 저장 못함
        }
        
        List<String> genreSorted = new ArrayList<>(genrePlayCountMap.keySet());
        genreSorted.sort((a, b) -> genrePlayCountMap.get(b) - genrePlayCountMap.get(a));
        
        List<Integer> answerList = new ArrayList<>();
        
        for (String genre : genreSorted) {
            List<int[]> songs = songMap.get(genre);
            
            // 재생횟수 내림차순 -> 같으면 고유번호 오름차순
            songs.sort((a, b) -> a[1] != b[1] ? b[1] - a[1] : a[0] - b[0]);
            
            // 최대 2곡까지 answerList에 고유번호 추가
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                answerList.add(songs.get(i)[0]);
            }
        }
        
        // List<Integer> -> int[]
        int[] answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}

/*
- 해시맵 저장 Map<String, List<int[]>> // 장르명 : [고유번호, 재생횟수]리스트
- 장르별 재생횟수 총합 구하고 -> 많은 순서대로 List<String> 장르명 생성
- 장르명 순서에 따라 Map 탐색
    - 재생횟수 내림차순 정렬, 동일하면 고유번호 오름차순 정렬
    - 최대 2곡까지 answer List에 추가
    // if 재생횟수리스트길이 == 1 -> answer에 고유번호 삽입
    // else: 재생횟수리스트에서 top2개의 고유번호를 answer List에 삽입
    
- answer List -> int[] 변환 후 리턴
*/