package BOJ;

import java.util.Scanner;

public class boj_11047_동전2 {
	
	static int min;
	static int N;
	static int K;
	static int[] coin;
	static int sum;
	static int cnt;
	static int idx;
	static int tmp;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		coin = new int[N];
		for(int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}
		min = Integer.MAX_VALUE;
		ans = Integer.MAX_VALUE;
//		int a = 0;
//		for(int i = 0; i < N; i++) {
//			a = K/coin[i];
//			if(a < min && a > 0 ) {
//				min = a;
//				idx = i;
//			}
//		}
//		System.out.println(a);
//		System.out.println(idx);
//		System.out.println(min);
		paycoin(K);
		
	}
	
	public static void paycoin(int change) { //왜 자꾸 스택 오버플로우,,?
		if(change == 0) {
			System.out.println(sum);
			return;
		}
		
		int a = 0;
		
		for(int i = 0; i < N; i++) {
			a = change/coin[i];
//			System.out.println(a);
			if(a < min && a > 0 ) {
				min = a;
				idx = i;
				tmp = change%coin[i];
			}
		}
		
		sum += min;
		
		paycoin(tmp);
	}
}
