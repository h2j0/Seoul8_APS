package Mar_3rd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj10814_나이순정렬 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[][] arr = new String[n][3];
		
		// string 이차원 배열에 정보를 받고 정렬
		for(int i = 0 ; i <n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken(); // 나이 
			arr[i][1] = st.nextToken(); // 이름
			arr[i][2] = i+""; // 입력된 순서
		}

		// 정렬 함수 재정의
		Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) { // 나이가 같은 경우
					return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]); // 입력된 순서 비교
				} else { // 나이가 다른 경우
					return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]); // 나이 비교
				}
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<n; i++) {
			sb.append(arr[i][0]+" "+arr[i][1]+"\n");
		}
		System.out.println(sb.toString());
		
		
	}

}
