package Apr_1st_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11399_ATM {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int[] tmp = new int[n];
		int sum = 0;
		for(int i = 0; i<n; i++) {
			sum += arr[i];
			tmp[i] = sum;
		}
		
		int ans = 0;
		for(int i = 0; i<n; i++) {
			ans += tmp[i];
		}
		System.out.println(ans);
		
	} // main 종료

}
