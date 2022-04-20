package Apr_3rd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj1931_회의실배정2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[i][0] = start; // 회의 시작 시간
			arr[i][1] = end; // 회의 종료 시간
		}
		
		// 활동 선택 문제
		// 한 사람이 특정 시간에 하나의 작업을 할 수 있는 경우, 가능한 최대 활동의 수를 구하는 문제
		// 탐욕 선택이 이후의 결과에 영향을 미치지 않는다.
		// 서로 겹치지 않는 활동에 대해 종료시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 늘어난다는 것이 핵심
		// 종료시간을 기준으로 오름차순 순서대로 정렬하되, 종료시간이 동일하면 시작시간 오름차순으로 정렬
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				
				if(o1[1] == o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		int ans = 0;
		int endTime = 0;
		
		for(int i = 0; i<n; i++) {
			// 직전 종료시간이 다음 회의 시작시간보다 이르거나 같으면 
			// 종료시간을 다음회의시간의 종료시간으로 갱신하고 ++;
			if(endTime <= arr[i][0]) {
				endTime = arr[i][1];
				ans++;
			}
			
		}
		
		System.out.println(ans);

	}

}
