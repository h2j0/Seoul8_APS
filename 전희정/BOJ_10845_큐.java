import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_10845_큐 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> queue = new LinkedList<>();
		int n = sc.nextInt();
		int len = 0;
		for (int i = 0; i < n; i++) {
			switch (sc.next()) {
			case "push":
				queue.add(sc.nextInt());
				len++;
				break;

			case "pop":
				if (len != 0) {
					sb.append(queue.remove(0) + "\n");
					len--;
				} else {
					sb.append("-1" + "\n");
				}
				break;

			case "size":
				sb.append(len + "\n");
				break;

			case "empty":
				sb.append(len == 0 ? "1" : "0");
				sb.append("\n");
				break;

			case "front":
				sb.append(len == 0 ? "-1" : queue.get(0));
				sb.append("\n");
				break;

			case "back":
				sb.append(len == 0 ? "-1" : queue.get(len - 1));
				sb.append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}
