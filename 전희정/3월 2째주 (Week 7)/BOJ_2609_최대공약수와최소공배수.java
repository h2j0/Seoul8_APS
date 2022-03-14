import java.util.Scanner;

public class BOJ_2609_최대공약수와최소공배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		// 큰 숫자에 맞춰서 배열 만들어줌
		int len = Math.max(a, b);
		int[] aprime = new int[len + 1];
		int[] bprime = new int[len + 1];

		// 1은 무조건 나눠지니까 2부터 나눈다
		int x = 2;
		// 소인수분해 18 -> 2 * 3^2 -> 배열 2번에 값1, 배열 3번에 값2
		while (a > 1) {
			if (a % x == 0) {
				a /= x;
				aprime[x]++;
			} else {
				x++;
			}
		}

		x = 2;
		while (b > 1) {
			if (b % x == 0) {
				b /= x;
				bprime[x]++;
			} else {
				x++;
			}
		}

		int gcd = 1; // 최대공약수
		int lcm = 1; // 최소공배수
		for (int i = 0; i <= len; i++) {
			if (aprime[i] != 0 && bprime[i] != 0) {
				// 공통 약수 가질 때
				// gcd는 작은 수를 제곱해야 함
				// lcm은 큰 수를 제곱해야 함
				gcd *= (int) Math.pow(i, Math.min(aprime[i], bprime[i]));
				lcm *= (int) Math.pow(i, Math.max(aprime[i], bprime[i]));
			} // lcm은 약수 다 곱해준다
			else if (aprime[i] != 0 && bprime[i] == 0) {
				lcm *= (int) Math.pow(i, aprime[i]);
			} else if (aprime[i] == 0 && bprime[i] != 0) {
				lcm *= (int) Math.pow(i, bprime[i]);
			}
		}

		System.out.println(gcd);
		System.out.println(lcm);
	}

}
