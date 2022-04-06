import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		// 0이 아니면 stack에 값을 집어넣고 0일 때 stack에서 빼낸다
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
				stack.push(num);
			} else {
				stack.pop();
			}
		}
		// 스택에 남아있는 값을 더하기
		int ans = 0;
		for (int i = 0; i < stack.size(); i++) {
			ans += stack.get(i);
		}
		System.out.println(ans);
	}
}
