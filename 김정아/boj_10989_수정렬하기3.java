package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class boj_10989_수정렬하기3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		 ArrayList<Integer> list = new ArrayList<>();

	     for (int i = 0; i < N; i++) {
	    	 list.add(sc.nextInt());
	     }
	     
	     Collections.sort(list);
		
	     for(int i = 0; i < list.size(); i++) {
	    	 System.out.println(list.get(i));
	     }
	     
	}
}
