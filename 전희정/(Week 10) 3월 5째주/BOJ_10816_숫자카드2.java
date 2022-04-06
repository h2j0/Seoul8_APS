import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 가지고 있는 카드 배열
		int[] card = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		// 배열 생성하면서 max, min값 구함
		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			max = Math.max(card[i], max);
			min = Math.min(card[i], min);
		}

		// min 값이 음수라면 조정 필요 (0번부터 시작하도록)
		// min값이 0이 되고 card의 값에서 min 값을 빼준다
		int tmpMax = max;
		int tmpMin = min;
		boolean flag = true;
		if (min < 0) {
			flag = false;
			for (int i = 0; i < n; i++) {
				card[i] -= min;
			}
			tmpMax -= min;
			tmpMin = 0;
		}

		// 카운트 배열 생성
		int[] cnt = new int[tmpMax + 1];
		for (int i = 0; i < card.length; i++) {
			cnt[card[i]]++;
		}
//		System.out.println(Arrays.toString(cnt));

		// 찾으려는 숫자 카드를 cnt배열의 인덱스값으로 찾아가서 비교
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < m; i++) {
			int find = Integer.parseInt(st.nextToken());
			// 찾으려는 카드가 min, max의 범위 내에 있으면 
			// min값이 양수였으면 그대로 cnt의 인덱스로
			// 음수였으면 cnt에서 min값 빼주고 인덱스로
			if (find >= min && find <= max) {
				sb.append(flag ? cnt[find] : cnt[find - min]).append(" ");
			} // 범위 내에 없으면 없는거니까 0 추가
			else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
	}
}
