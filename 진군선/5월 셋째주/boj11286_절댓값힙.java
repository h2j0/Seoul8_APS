package May_3rd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj11286_절댓값힙 {
	static class Num implements Comparable<Num>{
		int i, j; // 원래 수, 절대값

		public Num(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Num o) {
			if(this.j == o.j) {
				return this.i-o.i;
			}
			return this.j-o.j;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Num> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a != 0) {
				Num num = new Num(a, Math.abs(a));
				pq.add(num);
			} else {
				if (pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(pq.poll().i).append("\n");
				}
			}
		}
		
		System.out.println(sb);

	}

}
