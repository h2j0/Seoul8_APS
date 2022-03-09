import java.util.Arrays;
import java.util.Scanner;

public class BOJ_7568_덩치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[] w = new int[n]; // 무게
		int[] h = new int[n]; // 키
		int[] rank = new int[n]; //등수 저장

		for (int i = 0; i < n; i++) {
			w[i] = sc.nextInt();
			h[i] = sc.nextInt();
			rank[i] = 1; // 등수는 1등부터니까 1로 초기화
		}
		
		// i기준 j랑 비교하는데 j가 i보다 무게도 크고 키도 크면 i의 랭크가 증가
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (w[i] < w[j] && h[i] < h[j]) {
					rank[i]++;
				}
			}
			sb.append(rank[i]+" ");
		}
		System.out.println(sb);
	}
}
