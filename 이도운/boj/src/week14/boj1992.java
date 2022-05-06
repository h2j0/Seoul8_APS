package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1992 {
	static int N;
	static int[][] image;
	static String z;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		image = new int[N][N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			String[] ipt = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				image[i][j] = Integer.parseInt(ipt[j]);
				sum += image[i][j];
			}
		}

		if (sum == N * N) {
			System.out.println(1);
		} else if (sum == 0) {
			System.out.println(0);
		} else {
			z = "";
			qt(image);
			System.out.println(z);
		}

	}

	static void qt(int[][] timage) {
		int len = timage.length;
		z += "(";

		int[] lst = new int[len / 2];
		for (int i = 0; i < len / 2; i++) {
			lst[i] = i;
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				int[][] qimage = new int[len / 2][len / 2];
				int qsum = 0;
				for (int x = 0; x < len / 2; x++) {
					for (int y = 0; y < len / 2; y++) {
						qimage[x][y] = timage[x + i * (len / 2)][y + j * (len / 2)];
						qsum += qimage[x][y];
					}
				}
				if (qsum == len * len / 4) {
					z += "1";
				} else if (qsum == 0) {
					z += "0";
				} else {
					qt(qimage);
				}
			}
		}
		z += ")";

	}

}
