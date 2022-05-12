package May_2nd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11723_집합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[21];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int num = 0;
			if (st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
			}
			switch (op) {
			case "add":
				if(!arr[num]) arr[num] = true;
				break;
				
			case "remove":
				if(arr[num]) arr[num] = false;
				break;
				
			case "check":
				if(arr[num]) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
				
			case "toggle":
					if(arr[num]) arr[num] = false;
					else arr[num] = true;
				break;
				
			case "all":
				for(int j = 1; j<21; j++) {
					arr[j] = true;
				}
				break;
			case "empty":
				for(int j = 1; j<21; j++) {
					arr[j] = false;
				}
				break;
			}
		} // m close
		System.out.println(sb);
	}// main close

}
