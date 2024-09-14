class Solution {
    public int solution(int n, int[][] computers) {
    
        boolean[] visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(int computer, int[][] computers, boolean[] visited) {
        visited[computer] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[computer][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }
}

/*
- computers 배열은 컴퓨터간의 연결정보를 저장한 배열이다.
- 각 컴퓨터를 기준으로 탐색을 진행하고, 탐색을 완료한 컴퓨터는 표시를 해둔다(visited 배열)
- 하나의 네트워크에 연결된 컴퓨터들의 탐색이 끝나면 네트워크의 개수를 증가시킨다.
- 네트워크 개수만 구하면 되므로, 네크워크 구성 자체를 저장할 필요는 없다.
*/