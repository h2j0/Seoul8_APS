package Apr_4th_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1667_팩토리얼0의개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// dp로 해결 
		int[] dp = new int[501];
		int ans = 0;
		// 팩토리얼에서 n!의 끝의 0의 개수는 n!이 10의 k승인 배수일 때, k를 찾는 것
		// 10은 2*5이므로, 2와 5가 짝이 되는 개수를 찾으면 된다. 
		// 이때 2는 짝수마다 포함되므로, n!는 5가 몇 번 곱해진 수인지를 찾으면 된다.
		for (int i = 1; i <= 500; i++) {
			int num = i;
			// 팩토리얼은 n-1!에 n을 곱한 것이므로, 일단 n-1!이 갖는 5의 개수를 가져온다
			dp[i] = dp[i - 1];
			// 자신이 5의 배수일 때, 그만큼을 dp[i]에 저장
			while (num % 5 == 0) {
				dp[i]++;
				num /= 5;
				// 빠르게 반복문 나오기 위해 num==1일 때 탈출
				if (num == 1)
					break;
			}
		}

		System.out.println(dp[n]);

	}

}
