package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int d = 4;
		int dd = 20;

		while (dd <= n) {
			d += 1;
			int temp1 = 1;
			for (int i = 0; i < (d - 4) * 10; i++) {
				temp1 *= 9;
			}
			int temp2 = 1;
			for (int i = 0; i < d - 3; i++) {
				temp2 *= 10;
			}
			dd += (d - 3) * temp1 + temp2;
		}

		int n0;
		int temp1 = 1;
		int temp2 = 1;
		for (int i = 0; i < (d - 4) * 10; i++) {
			temp1 *= 9;
		}
		for (int i = 0; i < d - 3; i++) {
			temp2 *= 10;
		}
		n0 = n-(dd- (d-3)*temp1 - temp2);

	}

}
