package Mar_2nd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 최대공약수
		// 작은 수의 약수를 먼저 찾고, 약수 중 큰 수부터 다른 수를 나누어 봄. 나누어 떨어지면 break;
		int grComDiv = 0;
		if (n < m) {
			int nDiv = 0;
			for (int i = n; i >= 1; i--) {
				if (n % i == 0) nDiv = i;
				if (m % nDiv == 0) {
					grComDiv = i;
					break;
				}
			}
		} else if (n > m) {
			int mDiv = 0;
			for (int i = m; i >= 1; i--) {
				if (m % i == 0) mDiv = i;
				if (n % mDiv == 0) {
					grComDiv = i;
					break;
				}
			}
		} else grComDiv = n;
		

		// 최소공배수
		// 한 수를 최대공약수로 나누고, 그 몫으로 다른 수를 곱함.
		int lstComMul = m * (n/grComDiv);
		
		System.out.println(grComDiv);
		System.out.println(lstComMul);
		
	}

}
