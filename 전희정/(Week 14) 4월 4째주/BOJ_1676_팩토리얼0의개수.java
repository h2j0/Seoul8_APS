package BOJ;

import java.util.Scanner;

public class BOJ_1676_팩토리얼0의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 10의 배수가 몇개있는지 cnt
		// 10 = 2*5 => 2의 배수 개수와 5의 배수 개수 중 min값이 답
		// 근데 5의배수보다 2의배수가 무조건 많으니까 5의 배수만 고려해줘도 된다
		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			int tmp = i;
			while (tmp % 5 == 0) {
				cnt++;
				tmp = tmp / 5;
			}
		}
		System.out.println(cnt);
	}

}
