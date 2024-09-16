/*
- 최단 경로를 찾아야 하므로 BFS 사용
- DFS 백트래킹으로 푸니까 정확성 테스트는 전부 통과했지만 효율성 테스트에서 전부 실패함
*/

import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // 방문 여부 저장
        boolean[][] visited = new boolean[n][m];
        
        // BFS 큐 생성 (x, y, 이동 횟수)
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1}); // 시작점 (0, 0), 이동 횟수 1
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];
            
            // 도착했을 때
            if (x == m - 1 && y == n - 1) {
                return steps;
            }
            
            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 맵 내부이고, 벽 아니고, 방문하지 않은 곳일 때 이동
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && maps[ny][nx] == 1 && !visited[ny][nx]) {
                    queue.add(new int[] {nx, ny, steps + 1});
                    visited[ny][nx] = true;
                }
            }
        }
        
        // 상대 팀 진영에 도착할 수 없을 때
        return -1;
    }
}


// class Solution {
//     static int[] dx = {0, 0, -1, 1};
//     static int[] dy = {-1, 1, 0, 0};
//     static int minDistance = Integer.MAX_VALUE;
    
//     public int solution(int[][] maps) {
//         int n = maps.length;
//         int m = maps[0].length;
        
//         // 방문 여부를 체크하는 배열
//         boolean[][] visited = new boolean[n][m];
        
//         // DFS 탐색 시작
//         dfs(maps, visited, 0, 0, 1);
        
//         // 최단 경로가 갱신되지 않았다면, -1 리턴
//         return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
//     }
    
//     public void dfs(int[][] maps, boolean[][] visited, int x, int y, int distance) {
//         int n = maps.length;
//         int m = maps[0].length;
        
//         // 도착했을 떄
//         if (x == m - 1 && y == n - 1) {
//             minDistance = Math.min(minDistance, distance);
//             return;
//         }
        
//         // 현재 위치 방문 처리
//         visited[y][x] = true;
        
//         // 상하좌우로 이동
//         for (int i = 0; i < 4; i++) {
//             int nx = x + dx[i];
//             int ny = y + dy[i];
            
//             // 맵 내부이고, 벽 아니고, 방문하지 않은 곳일 때 이동
//             if (nx >= 0 && nx < m && ny >= 0 && ny < n && maps[ny][nx] == 1 && !visited[ny][nx]) {
//                 dfs(maps, visited, nx, ny, distance + 1);
//             }
//         }
        
//         // 다른 경로 탐색을 위해 현재 위치의 방문 처리를 취소함
//         visited[y][x] = false;
//     }
// }
