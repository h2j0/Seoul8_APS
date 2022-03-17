import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> stack = new Stack<>();

		int i = 0;
		for (int num = 1; num <= n; num++) {
			stack.push(num);
			sb.append("+").append("\n");

			while (!stack.isEmpty() && i < n && stack.peek() == arr[i]) {
				stack.pop();
				sb.append("-").append("\n");
				i++;
			}
		}
		if (stack.isEmpty())
			System.out.println(sb);
		else
			System.out.println("NO");
	}
}
