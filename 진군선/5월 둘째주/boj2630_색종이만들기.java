package May_2nd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2630_색종이만들기 {
	static int a, b;

	
	public static void main(String[] args) throws Exception {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 종이의개수와 같은 문제
		// 배열, 시작점, 끝 점, 탐색 범위를 보내고
		// 배열이 0||1으로 이루어지는지 확인한 후 그렇다면 해당하는 값++하고 return
		// 아니면 재귀로 보내기
		// 탐색범위는 n/2씩
		a = b = 0;
		paper(arr, 0, 0, n);
		
		sb.append(a).append("\n").append(b);
		System.out.println(sb);
		
	}

	private static void paper(int[][] arr, int r, int cl, int n) {
		if(n <1) return;
		
		boolean flag = false;
		loop: for(int i = r; i<r+n; i++) {
			for(int j = cl; j<cl+n; j++) {
				if(arr[i][j] != 0) {
					flag = true;
					break loop;
				}
			}
		}
		
		if(!flag) {
			a++;
			return;
		}
		
		flag = false;
		loop: for(int i = r; i<r+n; i++) {
			for(int j = cl; j<cl+n; j++) {
				if(arr[i][j] != 1) {
					flag = true;
					break loop;
				}
			}
		}
		
		if(!flag) {
			b++;
			return;
		}
		
		
		paper(arr, r, cl, n/2);
		paper(arr, r, cl+n/2, n/2);
		paper(arr, r+n/2, cl, n/2);
		paper(arr, r+n/2, cl+n/2, n/2);
		
		
	}

}
