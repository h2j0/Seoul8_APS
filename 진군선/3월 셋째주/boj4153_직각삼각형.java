package Mar_3rd_Week;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj4153_직각삼각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
//		ArrayList<ArrayList<Integer>> tc = new ArrayList<>();

		while (true) {
			String test = br.readLine();
			if (!test.equals("0 0 0")) {
				StringTokenizer st = new StringTokenizer(test);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				String result = "wrong";

				if (Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2)) {
					result = "right";
				} else if (Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2)) {
					result = "right";
				} else if (Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2)) {
					result = "right";
				}

				bw.write(result + "\n");
				bw.flush();
			} else {
				break;
			}
		}
		bw.close();

	}

}
