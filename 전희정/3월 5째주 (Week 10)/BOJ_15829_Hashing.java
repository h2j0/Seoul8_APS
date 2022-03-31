import java.util.Scanner;

public class BOJ_15829_Hashing {
	public static void main(String[] args) {
		int r = 31;
		int M = 1234567891;

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();

		int sum = 0;
		for (int i = 0; i < n; i++) {
			int num = str.charAt(i) - 'a' + 1;
			sum += num * Math.pow(r, i);
		}

		int res = sum%M;
		System.out.println(res);
	}
}
