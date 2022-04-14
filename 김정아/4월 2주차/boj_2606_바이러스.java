package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2606_바이러스 {
	
	static int[][] computer; // 컴퓨터 배열
	static int[] parent;
	static boolean[] visited;
	static int C; //컴퓨터 개수
	static int E; //간선 개수 (연결 쌍)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		C = sc.nextInt();
		E = sc.nextInt();
		
		computer = new int[C+1][C+1];
		parent = new int[C+1];
		for(int i = 0; i < E; i++) {
			int p = sc.nextInt();
			int c = sc.nextInt();
			
			computer[p][c] = 1; // 가르키는 간선 저장
			parent[c]++; // 카운팅
		}
		
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> wormvirus = new ArrayList<>();
		q.offer(1);
		
		while(!q.isEmpty()) {//어차피 1에서만 시작하니까 1에 연결된 애들만 들어감.
			int node = q.poll(); // 뽑고

			wormvirus.add(node); // 바이러스 걸리는거 추가
			for(int i = 1; i < C+1; i++) {
				if(computer[node][i] == 1) { // 
					parent[i]--;
					if(parent[i] == 0) {
						q.offer(i);
					}
				}
			}
		}
		
		System.out.println(wormvirus.size()-1); // 1이 포함되어 있기때문에 -1 해준다.
	}
}
