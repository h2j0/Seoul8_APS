import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11866_요세푸스문제0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		// 1부터 n까지 q에 넣어준다
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		// 괄호 열기
		sb.append("<");

		while (true) {
			// 빼고 넣기 K-1번 수행
			for (int i = 1; i < k; i++) {
				q.add(q.poll());
			}
			// 빼기
			sb.append(q.poll());
			// q가 비면 괄호 닫기
			if (q.isEmpty()) {
				sb.append(">");
				break;
			}
			// 괄호 닫히지 않으면 , 넣어주기
			sb.append(", ");
		}

		System.out.println(sb);
	}
}
