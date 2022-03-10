import java.util.Scanner;

public class BOJ_2231_분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String strn = n + "";
		int ans = 0;

		// 입력수의 자릿수*9만큼 반복
		// 216 => 216-1-9-8 = 198 (n=216 / m=198)
		// 216이 3자리니까 216-9-9-9까지 반복이라서 3*9만큼 반복
		for (int i = 0; i <= strn.length() * 9; i++) {
			int x = n;
			// n에서 하나씩 작아지는 값이 m
			int m = n - i;
			String strm = m + "";
			// x : n값에서 m의 자릿수를 하나씩 빼준다
			for (int j = 0; j < strm.length(); j++) {
				x -= (strm.charAt(j) - '0');
			}
			// n에서 m의 자릿수를 하나씩 빼준 값이 m이랑 같으면 답
			if (x == m) {
				ans = m;
			}
		}

		System.out.println(ans);
	}
}
