package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class boj_2805_나무자르기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long M = sc.nextInt();
		
		long[] namu = new long[N];
		for(int i = 0; i < N; i++) {
			namu[i] = sc.nextInt();
		}
		Arrays.sort(namu);

		long H = namu[N-1]; // 일단 가장 큰 통나무길이로 잡고
		long min = 0;
		long max = H;
		
		while(min<=max) {
			long sum = 0;
			long mid = (min+max)/2;
			for(int i = 0; i < N; i++) {
				if(namu[i] < mid) {
					continue;
				}else {
					sum+=(namu[i]-mid);//통나무 - 절단기 높이 합
				}
			}
			if(sum>=M) {
				min = mid+1;
			} else {
				max = mid-1;
			}
		}
		System.out.println(max);
		
	}
}
