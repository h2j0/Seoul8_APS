package Mar_5th_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2108_통계학 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		sb.append(ariAvg(arr)).append("\n");
		sb.append(mid(arr)).append("\n");
		sb.append(mode(arr)).append("\n");
		sb.append(range(arr)).append("\n");

		System.out.println(sb.toString());

	}

	private static int range(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			min = Integer.min(min, arr[i]);
			max = Integer.max(max, arr[i]);
		}

		int range = max - min;

		return range;
	}

	// 최빈값
	private static int mode(int[] arr) {

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			min = Integer.min(min, arr[i]);
		}

		int[] cnt = new int[8001];
		if (min < 0) {
			for (int i = 0; i < arr.length; i++) {
				cnt[arr[i] - min]++;
			}
		} else {
			for (int i = 0; i < arr.length; i++) {
				cnt[arr[i]]++;
			}
		}

		Arrays.sort(arr);
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for (int i = 0; i < 8001; i++) {
			if(max<cnt[i]) {
				max = cnt[i];
			}
		}
		
		int a = 0;
		for (int i = 0; i < 8001; i++) {
			if (cnt[i] == max) {
				a++;
				idx = i;
			}
			if (a == 2) {
				idx = i;
				break;
			}
		}
		
		if (min < 0) {
			return idx + min;
		} else {
			return idx;
		}
	}

	// 중앙값
	private static int mid(int[] arr) {
		Arrays.sort(arr);
		return arr[arr.length / 2];
	}

	// 산술평균
	private static int ariAvg(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		float avg = (float) sum / arr.length;

		return Math.round(avg);
	}

}
