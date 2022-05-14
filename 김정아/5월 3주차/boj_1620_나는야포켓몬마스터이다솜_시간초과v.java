package BOJ;

import java.util.*;
import java.io.*;

public class boj_1620_나는야포켓몬마스터이다솜{
	
	static ArrayList<pocketmon> pocket;
	static ArrayList<String> index;
	static ArrayList<String> monster;
	
	public static class pocketmon{
		String name;
		String idx;
		
		pocketmon(String name,String idx){
			this.name = name;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		pocket = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			pocket.add(new pocketmon(br.readLine(), Integer.toString(i+1)));
//			System.out.println(pocket.get(i).idx); 출력확인
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String tmp = br.readLine();
			for(int j = 0; j <pocket.size(); j++) {
				if(tmp.equals(pocket.get(j).idx)) {
					sb.append(pocket.get(j).name);
					sb.append("\n");
				}else if(tmp.equals(pocket.get(j).name)) {
					sb.append(pocket.get(j).idx);
					sb.append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
