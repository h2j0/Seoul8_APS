package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class boj_18870_좌표압축6 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] origin = new int[N];
		ArrayList<Integer> comp = new ArrayList<>();
		//입력 받는 애들을 두군데 나눠서 담아
		for(int i = 0; i < N; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
			comp.add(origin[i]);
		}
		//하나는 미리 정렬
		Collections.sort(comp); //얘는 순회하면서 map에 담아줄 아이 그냥 정렬을 해주고 그거에 값을 매겨서 담는게 빠른가보다..
		HashMap<Integer, Integer> level = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		//그 정렬한 애를 순회하면서 map에 담아준다.여기서 알아서 중복 제거
		int lev = 0;
		for(int num: comp) {
			if(!level.containsKey(num)) { //없는 경우에만 넣어주기
				level.put(num, lev);
				lev++;
			}
		}
		for(int num: origin) {//origin배열 순회하면서 
			int L = level.get(num);//level에 든 level을 가쟈온다.
			sb.append(L+" ");
		}
		System.out.println(sb);
	}
}
