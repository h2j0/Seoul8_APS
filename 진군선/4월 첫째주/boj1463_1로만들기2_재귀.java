package Apr_1st_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Currency;
import java.util.Stack;

public class boj1463_1로만들기2_재귀 {
	static class Pos {
		int num, cnt;

		public Pos(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}

	}

	static Stack<Pos> stack = new Stack<>();
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// DFS 이용해서 탐색

		// stack을 하나 만든다
		Pos pos = new Pos(n, 0);

		dfs(pos);
		
		
		System.out.println(ans);
	}// main 종료
	private static void dfs(Pos pos) {
		// stack에 n을 넣는다
		stack.add(pos);
		// stack이 빌 때까지 반복
		if(stack.isEmpty())
			return;
		
			// 한개 뽑는다
			Pos curr = stack.pop();
			
			if (curr.num == 1) {
				ans = Math.min(ans, curr.cnt);
				return;
			}
			
			if (curr.num - 1 > 0 && curr.cnt + 1 < ans)
				dfs(new Pos(curr.num - 1, curr.cnt + 1));
			if (curr.num % 2 == 0 && curr.num / 2 > 0 && curr.cnt + 1 < ans) {
				dfs(new Pos(curr.num / 2, curr.cnt + 1));
			}
			if (curr.num % 3 == 0 && curr.num / 3 > 0 && curr.cnt + 1 < ans) {
				dfs(new Pos(curr.num / 3, curr.cnt + 1));
			}
			
		
	}

}
