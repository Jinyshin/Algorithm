from sys import stdin
input = stdin.readline

T = int(input())

for _ in range(T):
  stack = []
  par = input().strip()
  isVPS = True

  for i in par:
    if i == '(':
      stack.append(i)
    elif i == ')':
      if stack:
        stack.pop()
      else:
        isVPS = False
        break
  if len(stack) == 0 and isVPS:
    print("YES")
  elif len(stack) or not isVPS:
    print("NO")