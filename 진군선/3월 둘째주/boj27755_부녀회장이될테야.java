package Mar_2nd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj27755_부녀회장이될테야 {

	public static void main(String[] args) throws Exception {
		// 아파트 입주민의 규칙과 범위가 주어져있으므로 미리 계산해놓은 테스트 케이스마다 답만 불러오는 방식으로 한다
		// 아파트는 0~14층까지 있고 14호까지 있으므로 15X14 배열 이용
		int[][] apt = new int[15][14];
		// 아파트 0층의 입주민의 수는 자신의 호수와 같다(인덱스는 0부터 시작하므로 배열의 요소값은 i에 1씩 더해서 대입)
		for(int i = 0; i<14; i++) {
			apt[0][i] = i+1;
		}
		// 0층의 입주민은 입력했으므로 1층부터 올라가면서 입주민을 구한다. 
		for(int i = 1; i<15; i++) {
			// 1호의 주민은 층과 관계없이 1이므로 층을 올라갈 때마다 1 대입
			apt[i][0] = 1;
			// 0층과 1호의 입주민은 입력했으므로 2호 입주민부터 구한다.
			for(int j = 1; j<14; j++) {
				// i층 j+1호의 입주민 수는 자신의 앞집 입주민 수에 자신의 아랫집 입주민 수를 더한 것과 같다
				apt[i][j] = apt[i][j-1]+ apt[i-1][j];
			}
		}
		// 테스트 케이스 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<t; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			//출력
			System.out.println(apt[k][n-1]);
		}// tc 종료
		
	} // main 종료

}
