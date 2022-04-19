package Apr_3rd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		// -를 만나면 다음 - 을 만날 때까지 앞의 수에서 뺀다. 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// -를 기준으로 식을 구분한다
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		int length = st.countTokens();
		// 토큰의 개수만큼의 크기인 배열을 만들어 식을 저장한다.
		int[] arr = new int[length];
		
		for(int i = 0; i<length; i++) {
			String a = st.nextToken();
			int x = 0;
			// 만일 한 토큰 안에 +가 있다면, 그만큼을 다 더한다.
			if(a.contains("+")) {
				StringTokenizer st2 = new StringTokenizer(a, "+");
				int length2 = st2.countTokens();
				for(int j = 0; j<length2; j++) {
					x += Integer.parseInt(st2.nextToken());
				}
			} else {
				x = Integer.parseInt(a);
			}
			arr[i] = x;
		}
		
		// 제일 앞의 토큰에서 뒤 토큰들을 다 뺀다.
		int ans = arr[0];
		for(int i = 1; i<arr.length; i++) {
			ans -= arr[i];
		}
		
		System.out.println(ans);
	}

}
