package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_10814_나이순정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		String[][] judge = new String[T][2];
		StringBuilder sb = new StringBuilder();
		
		
			for(int i = 0; i < T; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				judge[i][0] = st.nextToken();
				judge[i][1] = st.nextToken();
			}
			
			
			Arrays.sort(judge, new Comparator<String[]>() {

				@Override
				public int compare(String[] o1, String[] o2) {
					// TODO Auto-generated method stub
					return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
				}
			});
			
			for(int i = 0 ; i < T; i++) {
				sb.append(judge[i][0]).append(" ").append(judge[i][1]).append("\n");
			}
			System.out.println(sb);
	}
}
