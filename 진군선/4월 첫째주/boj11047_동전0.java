package Apr_1st_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11047_동전0 {
	static int ans;
	static int[] coins;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		coins = new int[n];
		// 내림차순으로 동전을 받는다
		for (int i = n - 1; i >= 0; i--) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		// 금액과 체크한 동전의 인덱스 값을 parameter로 보낸다.
		needCoin(k, 0);
		System.out.println(ans);

	}
	
	private static void needCoin(int k, int i) {
		// 금액이 큰 동전이 작은 동전의 배수이므로 큰 금액으로 먼저 나눈 나머지를 작은 동전으로 메꿀 때 동전을 최소로 사용
		// 목표 금액이 동전으로 나누어 떨어지면 답에 몫을 더하고 리턴
		if (k % coins[i] == 0) {
			ans += k / coins[i];
			return;
			
		// 그렇지 않은 경우
		} else {
			// 목표 금액이 동전보다 큰 경우, 동전으로 나눈 몫을 답에 더하고, 목표 금액은 나머지로 바꿈
			if (k / coins[i] > 0) {
				ans += (k / coins[i]);
				k = k % coins[i];
			}
			// 목표 금액이 동전보다 작은 경우, 목표 금액을 바꾸지 않음
			// 목표 금액을 다음번 동전으로 나누어보기
			needCoin(k, i + 1);
		}

	}

}
