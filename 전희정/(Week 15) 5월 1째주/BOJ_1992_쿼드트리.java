package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
	static int[] dr = { 0, 0, 1, 1 };
	static int[] dc = { 0, 1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
				
		String[][] video = new String[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				video[i] = str.split("");
			}
		}

		int size = n;
		// 자기 자신의 절반의 배열을 만들면서 압축해나간다
		String[][] compress = null;
		// 배열 사이즈가 1이면 압축 멈초ㅑ
		while (size > 1) {
			// 절반 사이즈 배열 만들고
			size /= 2;
			compress = new String[size][size];
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					String temp = "(";
					for (int k = 0; k < 4; k++) {
						temp += video[i*2 + dr[k]][j*2 + dc[k]];
					}
					temp += ")";
					if (temp.equals("(1111)")) {
						temp = "1";
					} else if (temp.equals("(0000)")) {
						temp = "0";
					}
					compress[i][j] = temp;
				}
			}
			// 값 복사
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					video[i][j] = compress[i][j];
				}
			}
			
		}
		for (int i = 0; i < compress.length; i++) {
			sb.append(compress[0][i]);
		}
		System.out.println(sb);
	}

}
