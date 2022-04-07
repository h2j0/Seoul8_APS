import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_2108_통계학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		double sum = 0;
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			// 입력 받으면서 합계랑 최대값 최소값 구한다
			sum += arr[i];
			max = max < arr[i] ? arr[i] : max;
			min = min > arr[i] ? arr[i] : min;
		}
		// 1. 산술 평균
		sb.append(Math.round(sum / n)).append("\n");

		// 2. 중앙값
		Arrays.sort(arr);
		sb.append(arr[n / 2]).append("\n");

		// 3. 최빈값
		// 음수가 있을 때를 고려 -> 양수로 만들어준다
		boolean flag = true;
		if (min < 0) { // 음수가 존재하면 flag=false
			flag = false;
			for (int i = 0; i < n; i++) {
				arr[i] -= min;
			}
		}
		
		// 빈도수 카운트 배열을 만든다
		int cntSize = flag ? max : max - min; // 최소값이 음수일 때 고려
		// cnt의 인덱스는 숫자, 값은 그 숫자의 빈도수
		int[] cnt = new int[cntSize + 1];
		for (int i = 0; i < n; i++) {
			cnt[arr[i]]++;
		}

		// 최대 빈도 수 찾기
		int maxCnt = 0;
		for (int i = 0; i < cnt.length; i++) {
			maxCnt = Math.max(maxCnt, cnt[i]);
		}

		// 최대 빈도수의 인덱스 찾기
		// 여러개일 때 두번째로 큰 값 찾기
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] == maxCnt) {
				list.add(i);
			}
		}
		Collections.sort(list);
		if (list.size() > 1) {
			sb.append(flag ? list.get(1) : list.get(1) + min).append("\n");
		} else {
			sb.append(flag ? list.get(0) : list.get(0) + min).append("\n");
		}

		// 4. 범위
		sb.append(max - min);

		System.out.println(sb);

	}
}
