package Mar_5th_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj11866_요세푸스문제0 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> list = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		sb.append("<");
		while(list.size()>1) {
			for(int i = 0; i< k-1; i++) {
				int x = list.poll();
				list.add(x);
			}
			sb.append(list.poll()).append(", ");
		}
		
		sb.append(list.poll()).append(">");
		System.out.println(sb);
	}

}
