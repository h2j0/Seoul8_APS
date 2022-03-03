package mar_1st_week;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2231_분해합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int k = 0; // 정답 받을 변수 

		// n보다 작은 수들을 돌면서 분해합을 찾기
		for (int i = 1; i < n; i++) { 
			k = i; // n은 k의 분해합이므로 k를 찾기 위해 k = i로 지정
			int sum = i; // i의 분해합 결과를 판단하기 위한 변수
			int m = i; // i의 각 자리 숫자를 받기 위한 변수
			while (m >= 1) { // m<0일 때 반복 종료
				if (m < 10) { // m이 10보다 작으면 분해합에 더하고 반복 종료
					sum += m;
					break;
				} else { // m이 10보다 크면 m을 10으로 나눈 나머지를 더하고 반복 계속
					sum += m % 10;
				} 
				m = m / 10; // m이 10보다 큰 경우이므로 m을 10을 나눈 몫을 m에 대입
			}

			if (sum == n) // 반복문 다 돌고 분해합이 n과 같으면 종료
				break;
		}
		
		// 출력 *** 분해합이 없는 경우 0 출력 ***
		if (k == n - 1) // 분해합이 없는 경우는 for문을 빠져나오지 못해 n-1까지 돌므로 k=n-1
			System.out.println(0);
		else
			System.out.println(k);

	}
}
