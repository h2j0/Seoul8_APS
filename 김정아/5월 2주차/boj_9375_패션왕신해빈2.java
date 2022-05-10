package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj_9375_패션왕신해빈2 {
	
	static ArrayList<fashion> set;
	static ArrayList<fashion> res;
	static ArrayList<String> tmp;
	static ArrayList<fashion> temp;
	static int n;
	static int cnt;
	static boolean[] sel;
	static int[] choose;
	
	public static class fashion {
		String name; //의상 이름
		String kind; //의상 종류
		
		fashion(String name, String kind) {
			this.name = name;
			this.kind = kind;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			n = sc.nextInt();
			set = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				String wearName = sc.next();
				String wearKind = sc.next();
				set.add(new fashion(wearName, wearKind));
			}
			
//			for(int i = 0; i < n; i++) { //출력확인
//				System.out.print(set.get(i).name+" ");
//				System.out.print(set.get(i).kind+" ");
//				System.out.println();
//			}
			sel = new boolean[set.size()];
			choose = new int[set.size()];
			powerset(0);
			
		}
	}
	
	
	public static void powerset(int idx) {
		if(idx == sel.length) {
			tmp = new ArrayList<>();
			temp = new ArrayList<>();
			res = new ArrayList<>();
			for(int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					res.add(set.get(i));
				}
			}
			cnt = 0;
			if(!res.isEmpty()) {
				for(int i = 0; i < res.size(); i++) {
					if(!tmp.contains(res.get(i).kind)) {
						tmp.add(res.get(i).kind);
						temp.add(res.get(i));
					}
				}
			}
			System.out.println("이거슨"+tmp);			
			//출력 확인용
			for(int i = 0; i < temp.size(); i++) {
				System.out.print("세트"+temp.get(i).name+" ");
//				System.out.print(temp.get(i).kind);
//				System.out.println();
			}
		
			System.out.println();
			return;
		}
		
		sel[idx] = true;
		powerset(idx+1);
		sel[idx] = false;
		powerset(idx+1);
	}
}
