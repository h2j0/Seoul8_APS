package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279_최대힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
				
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			// 들어오는 숫자가 0이면
			if(num==0) {
				// 프큐가 비어있다면 출력값에 0 넣기
				if(pq.isEmpty()) {
					sb.append("0").append("\n");
				}else {
					// 뭔가 있으면 빼내
					sb.append(pq.poll()).append("\n");
				}
			}else { // 들어오는 수가 0이 아니라면 프큐에 담아
				pq.add(num);
			}
			
		}
		System.out.println(sb);
	}
}
