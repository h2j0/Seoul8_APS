package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1676 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int ft = 0;

		for (int i = 1; i <= 3; i++) {
			int p5 = 1;
			for (int j = 0; j < i; j++) {
				p5 *= 5;
			}
			ft += n / p5;
		}
		System.out.println(ft);

	}

}
