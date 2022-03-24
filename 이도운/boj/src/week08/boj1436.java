package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class boj1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<Integer>();
		

		int n = Integer.parseInt(br.readLine());
		String six = "666";

		for (int digit = 4; digit < 8; digit++) {
			for (int pwr = 0; pwr < (int) Math.pow(10, digit - 3); pwr++) {
				String strPwr = String.format("%05d", pwr);
				for (int btw = 0; btw <= strPwr.length(); btw++) {
					int movieName = Integer.parseInt((strPwr.substring(0, btw)+six+strPwr.substring(btw, strPwr.length())));
					set.add(movieName);
				}
			}
		}
		Integer[] array = new Integer[set.size()];
		set.toArray(array);
		Arrays.sort(array);
		System.out.println(array[n-1]);

	}

}
