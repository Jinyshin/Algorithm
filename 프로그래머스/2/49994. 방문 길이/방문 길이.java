import java.util.*;

class Solution {
    public int solution(String dirs) {
        List<int[][]> firstVisited = new ArrayList<>();
        
        int x = 0;
        int y = 0;
        
        // 명령어 하나씩 순회
        for (int i = 0; i < dirs.length(); i++) {
            char currDir = dirs.charAt(i);
            int[] nextPos = move(x, y, currDir);
            
            // 이동 없으면 continue
            if (nextPos[0] == x && nextPos[1] == y) continue;
            
            int[][] newPath = {{x, y}, {nextPos[0], nextPos[1]}};
            int[][] reversedPath = {{nextPos[0], nextPos[1]}, {x, y}};
            
            boolean isNewPath = true;
            for (int[][] visitedPath: firstVisited) {
                if (Arrays.deepEquals(visitedPath, newPath) || Arrays.deepEquals(visitedPath, reversedPath)) {
                    isNewPath = false;
                    break;
                }
            }
            
            if (isNewPath) {
                firstVisited.add(newPath);
            }
            
            x = nextPos[0];
            y = nextPos[1];
        }
        
        return firstVisited.size();
    }
    
    // 다음 위치로 이동하는 함수
    public int[] move(int x, int y, char currDir) {
        int[] nextPos = switch (currDir) {
            case 'U' -> {
                if (y + 1 <= 5) yield new int[]{x, y + 1};
                else yield new int[]{x, y};
            }
            case 'D' -> {
                if (y - 1 >= -5) yield new int[]{x, y - 1};
                else yield new int[]{x, y};
            }
            case 'R' -> {
                if (x + 1 <= 5) yield new int[]{x + 1, y};
                else yield new int[]{x, y};
            }
            case 'L' -> {
                if (x - 1 >= -5) yield new int[]{x - 1, y};
                else yield new int[]{x, y};
            }
            default -> new int[]{x, y};
        };

        return nextPos;
    }
}

/*
- 처음 걸어본 길의 '길이' 구하기.

2. 방문여부 저장하는 배열 만들기: List<int[][]> firstVisited [[x, y], [nx, ny]]: 시작-종료좌표
3. dirs 명령어 charAt으로 접근하면서 명령어 하나씩 순회
    - 좌표평면 경계 만족하면 이동(좌표값 변경하기)
    - 시작좌표, 종료좌표 2차원 배열로 만들기
    - [시작, 종료], [종료, 시작] 모두 visited에 없으면 -> 저장하기
4. firstVisited 길이 구하기

O(n), n max == 500, OK!
*/