import java.util.Scanner;
import java.util.LinkedList;
 
public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = in.nextInt();	// 테스트 케이스 
 
		while (T-- > 0) {
			
			int N = in.nextInt();
			int M = in.nextInt();
			
			LinkedList<int[]> q = new LinkedList<>();
 
			for (int i = 0; i < N; i++) {
				// {초기 위치, 중요도}
				q.offer(new int[] { i, in.nextInt() });
			}
 
			int count = 0;
			
			while (!q.isEmpty()) {
				
				int[] front = q.poll();
				boolean isMax = true;
				
				for(int i = 0; i < q.size(); i++) {
					
					if(front[1] < q.get(i)[1]) {
						
						q.offer(front);
						for(int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						
						isMax = false;
						break;
					}
				}
				if(isMax == false) {
					continue;
				}
				
				count++;
				if(front[0] == M) {
					break;
				}
 
			}
 
			sb.append(count).append('\n');
 
		}
		System.out.println(sb);
	}
 
}