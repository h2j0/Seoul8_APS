import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			// 탈출 조건
			if (str.equals(".")) {
				break;
			}
			// 문자열 돌면서 괄호 찾기
			boolean flag = true;
			for (int i = 0; i < str.length(); i++) {
				char x = str.charAt(i);
				// 열림괄호 무조건 넣기
				if (x == '(' || x == '[') {
					stack.push(x);
				} // 닫힘괄호가 들어오면
				else if (x == ')') {
					// 스택이 비어있지 않고 맨 위에가 짝꿍이면 pop
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						flag = false;
						break;
					}
				} else if (x == ']') {
					// 스택이 비어있지 않고 맨 위에가 짝꿍이면 pop
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						flag = false;
						break;
					}
				}

			} // for문 끝
			// 반례 : ( [ ] ) [ [ -> 스택 비었는지 확인해야함
			if (flag && stack.isEmpty()) {
				System.out.println("yes");
			} else
				System.out.println("no");
		}

	}
}
