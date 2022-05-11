package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj1107 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int ans = (100 > n) ? (100 - n) : (n - 100);

		HashSet<Character> ooo = new HashSet<Character>();
		if (m != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				ooo.add(st.nextToken().charAt(0));
			}
		}

		for (int num = 0; num < 1000001; num++) {
			boolean flag = true;
			String numStr = String.valueOf(num);
			for (int j=0; j<numStr.length(); j++) {
				if (ooo.contains(numStr.charAt(j))) {
					flag=false;
					break;
				}
			}

			if (flag) {
				int nAns = numStr.length() + ((num > n) ? num - n : n - num);
				ans = (ans < nAns) ? ans : nAns;
			}
		}
		System.out.println(ans);

	}

}
