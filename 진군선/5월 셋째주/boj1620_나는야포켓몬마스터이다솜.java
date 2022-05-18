package May_3rd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> names = new HashMap<>(n+1);
		Map<String, Integer> nums = new HashMap<>(n+1);
		
		for(int i = 1; i <=n; i++) {
			String name = br.readLine();
			names.put(i, name);
			nums.put(name, i);
		}
		
		for(int i = 0; i<m; i++) {
			String problem = br.readLine();
			
			if('A'<= problem.charAt(0) && problem.charAt(0)<= 'Z' 
					|| 'a'<= problem.charAt(0) && problem.charAt(0)<= 'z' ) {
						sb.append(nums.get(problem)).append("\n");
			} else{
				sb.append(names.get(Integer.parseInt(problem))).append("\n");
			}
			
		}
		
		System.out.println(sb);
		
		
	}

}
