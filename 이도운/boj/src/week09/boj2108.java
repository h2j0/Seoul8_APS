package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] data = new int[n];
		int[] count = new int[8001];

		int sum = 0;
		int min = 4001;
		int max = -4001;

		for (int i = 0; i < n; i++) {
			int ipt = Integer.parseInt(br.readLine());
			data[i] = ipt;
			count[ipt + 4000] += 1;
			sum += ipt;
			min = (min < ipt) ? min : ipt;
			max = (max > ipt) ? max : ipt;
		}
		System.out.println(Math.round((double) sum / (double) data.length));
		Arrays.sort(data);
		System.out.println(data[data.length / 2]);

		int cnt1 = 0;
		int cnt2 = 1;

		for (int i = 0; i < 8001; i++) {
			if (count[i] > cnt1) {
				cnt1 = count[i];
				cnt2 = 1;
			} else if (count[i] == cnt1) {
				cnt2 += 1;
			}
		}
		int[] modes = new int[cnt2];
		int mIdx = 0;
		for (int i = 0; i < 8001; i++) {
			if (count[i] == cnt1) {
				modes[mIdx++] = i - 4000;
			}
		}
		Arrays.sort(modes);

		System.out.println(modes[((modes.length == 1) ? 0 : 1)]);
		System.out.println(max - min);

	}

}
