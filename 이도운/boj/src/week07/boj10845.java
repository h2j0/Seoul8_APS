package week07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class boj10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int backV = 0;
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String[] ipt = br.readLine().split(" ");

			switch (ipt[0]) {
			case "push":
				backV = Integer.parseInt(ipt[1]);
				q.add(backV);
				break;
			case "pop":
				int x = (q.isEmpty()) ? -1 : q.poll();
				System.out.println(x);
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				int isEmp = (q.isEmpty()) ? 1 : 0;
				System.out.println(isEmp);
				break;
			case "front":
				int frontV = (q.isEmpty()) ? -1 : q.peek();
				System.out.println(frontV);
				break;
			case "back":
				backV = (q.isEmpty()) ? -1 : backV;
				System.out.println(backV);
				break;
			}

		}

	}

}
