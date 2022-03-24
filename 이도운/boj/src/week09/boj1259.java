package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String word = br.readLine();

			if (word.charAt(0) == '0') {
				break;
			} else {
				String ans = "yes";
				for (int i = 0; i < word.length() / 2 + 1; i++) {
					if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
						ans = "no";
						break;
					}
				}
				System.out.println(ans);
			}

		}

	}

}
