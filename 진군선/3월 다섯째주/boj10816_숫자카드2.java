package Mar_5th_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10816_숫자카드2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] cards = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		// 이진탐색해야 시간초과 안걸림
		Arrays.sort(cards);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
		sb.append(upperBound(cards, num)-lowerBound(cards, num)).append(" ");
		}

		System.out.println(sb);

	}
	
	// Upper Bound
	// key를 '초과'한 값이 처음으로 나타나는 위치
	// key는 포함하지 X
	private static int upperBound(int[] cards, int num) {
		int lo = 0;
		int hi = cards.length;
		while (lo < hi) {
			int mid = (lo + hi)/2;
			// num이 cards[mid]보다 작은 경우 왼쪽 탐색 
			if(num < cards[mid]) {
				hi = mid;
			} 
			// num이 cards[mid]보다 같거나 큰 경우 오른쪽 탐색
			else {
				lo = mid +1;
			}
			
		}
		
		return lo;
	}
	
	// Lower Bound
	// key "이상"의 값이 처음으로 나타나는 위치
	// arr에 key가 있다면 key가 처음 나타나는 위치, 없다면 key보다 큰 값이 처음 나타나는 위치
	private static int lowerBound(int[] cards, int num) {
		int lo = 0;
		int hi = cards.length;
		
		// 이분탐색
		while(lo<hi) {
			int mid = (lo+hi)/2;
			// num이 cards[mid]보다 작거나 같은 경우 왼쪽 탐색
			if(num <= cards[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		
		return lo;
	}


}
