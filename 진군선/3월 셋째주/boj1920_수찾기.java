package Mar_3rd_Week;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1920_수찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arrN = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		int[] arrM = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}

		// arrN을 정렬하고 이진 탐색
		Arrays.sort(arrN);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int result = 0; // 결과 담을 변수
			int start = 0; // 시작 idx
			int end = n - 1; // 끝 idx

			// 시작idx가 끝idx보다 작거나 같을 때까지만 반복
			while (start <= end) {
				// 중간idx는 두 수의 절반
				int mid = (start + end) / 2; // 가운데 idx
				// arrM[i]가 arrN[mid]와 같으면 결과를 1로 저장하고 break;
				if (arrM[i] == arrN[mid]) {
					result = 1;
					break;
					// arrM[i]가 arrN[mid]보다 작으면 mid 왼쪽에서 탐색
				} else if (arrM[i] < arrN[mid]) {
					end = mid - 1;
					// arrM[i]가 arrN[mid]보다 크면 mid 오른쪽에서 탐색
				} else {
					start = mid + 1;
				}
			}
			sb.append(result+"\n");
		}
		bw.write(sb.toString());
		bw.close();
	}

}
