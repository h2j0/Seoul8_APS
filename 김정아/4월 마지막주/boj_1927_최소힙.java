package BOJ;

import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1927_최소힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		PriorityQueue<Integer> minimheap = new PriorityQueue<>();
		// 우선순위 큐 사용...
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num == 0) {
				if (minimheap.isEmpty()) {
					System.out.println("0"); // 그냥 비어있을때는 0 바로 출력
				} else {
					System.out.println(minimheap.poll()); // 아니면 큐에서 하나 뽑뽑
				}
			} else {
				minimheap.add(num);// 아니면 넣기
			}
		}
	}
}
