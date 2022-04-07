import java.util.Scanner;

public class BOJ_4153_직각삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			int[] arr = new int[3];
			int max = 0;
			
			// 숫자 3개를 입력받으면서 최대값 찾기
			for (int i = 0; i < 3; i++) {
				arr[i] = sc.nextInt();
				max = Math.max(max, arr[i]);
			}
			// 0 0 0 입력받으면 종료
			if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
				break;
			}
			
			// a^2 + b^2 == max^2 ? "right":"wrong" 
			int x = 0;
			for (int i = 0; i < 3; i++) {
				if (arr[i] != max) {
					x += Math.pow(arr[i], 2);
				}
			}
			sb.append(x == Math.pow(max, 2) ? "right" : "wrong").append("\n");
		}
		System.out.println(sb);
	}
}
