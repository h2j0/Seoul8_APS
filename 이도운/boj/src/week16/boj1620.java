package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> pokeName = new HashMap<String, Integer>();
		String[] pokeNum = new String[n + 1];

		for (int i = 0; i < n; i++) {
			String ipt = br.readLine();
			pokeName.put(ipt, i + 1);
			pokeNum[i + 1] = ipt;
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<m; i++) {
			String ipt = br.readLine();
			Scanner sc = new Scanner(ipt);
			if (!sc.hasNextInt()) {
				sb.append(pokeName.get(ipt)+"\n");
			}else {
				sb.append(pokeNum[Integer.parseInt(ipt)]+"\n");
			}
		}
		System.out.println(sb);

	}

}
