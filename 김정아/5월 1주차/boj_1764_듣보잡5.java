package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_1764_듣보잡5 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
	
		Set<String> hashSet = new HashSet<String>();
		//hashSet은 중복이 불가 / 순서가 없다 / 그리고 주소로 값을 찾는거라서 시간이 빠르다.
		
		ArrayList<String> res = new ArrayList<>();
		for(int i = 0; i < N+M; i++) {
			String name = br.readLine();
			if(!hashSet.contains(name)) {
				hashSet.add(name);
			}else {
				res.add(name);
			}
		}
		Collections.sort(res);
		sb.append(res.size());
		for(int i = 0; i < res.size(); i++) {
			sb.append('\n').append(res.get(i));
		}
		System.out.println(sb);
		
		
	}
}
