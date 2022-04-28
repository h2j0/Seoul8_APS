package BOJ;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_11279_최대힙2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		PriorityQueue<Integer> maxmheap = new PriorityQueue<>(Collections.reverseOrder());
		// 우선순위 큐 사용...
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num == 0) {
				if (maxmheap.isEmpty()) {
					System.out.println("0"); // 그냥 비어있을때는 0 바로 출력
				} else {
					System.out.println(maxmheap.poll()); // 아니면 큐에서 하나 뽑뽑
				}
			} else {
				maxmheap.add(num);// 아니면 넣기
			}
		}
	}
	
}
