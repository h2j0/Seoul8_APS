package done;
import java.util.Scanner;

public class BOJ_2775_부녀회장이될테야 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int k = sc.nextInt();
			int n = sc.nextInt();

			int[][] arr = new int[k + 1][n + 1];
			int x = 1;
			for (x = 1; x <= n; x++) {
				arr[0][x] = x;
			}

			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
				}
			}
			System.out.println(arr[k][n]);
		}
	}
}
