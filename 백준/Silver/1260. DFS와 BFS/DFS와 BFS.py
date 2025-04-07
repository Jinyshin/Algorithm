from collections import deque
n, m, v = map(int, input().split())
graph = [[0] * (n+1) for i in range(n+1)]
for _ in range(m):
  tn, tm = map(int, input().split())
  graph[tn][tm] = 1
  graph[tm][tn] = 1
visited = [False] * (n+1)

def dfs(g, v):
  global visited
  visited[v] = True
  print(v, end=' ')
  for i in range(1, n+1):
    if not visited[i] and g[v][i]:
      dfs(g, i)

def bfs(g, v):
  global visited
  visited = [False] * (n+1)
  visited[v] = True
  queue = deque([v])

  while queue:
    v = queue.popleft()
    print(v, end=' ')
    for i in range(1,n+1):
      if not visited[i] and g[v][i]:
        queue.append(i)
        visited[i] = True

dfs(graph, v)
print()
bfs(graph, v)