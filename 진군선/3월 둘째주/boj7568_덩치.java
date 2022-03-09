package Mar_2nd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj7568_덩치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		// 1차원 배열 2개로 키와 몸무게를 받음 
		// i번째 키와 몸무게가 모두 더 큰 사람의 수를 카운트 해서 출력하는 걸 n번 반복
		int[] weight = new int[n];
		int[] height = new int[n];

		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<n; i++) {
			int num = 1;
			for(int j = 0; j<n; j++) {
				if(weight[i] < weight[j] && height[i] < height[j]) num++;
			}
			sb.append(num).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
