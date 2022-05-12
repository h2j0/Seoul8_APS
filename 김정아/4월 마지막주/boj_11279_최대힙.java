package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_11279_최대힙 {

	// heap담을 배열 하나 만들고
	public static ArrayList<Integer> heap;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

	
			heap = new ArrayList<>();
			heap.add(0);
			
			int N = sc.nextInt();
			
			for (int t = 1; t <= N; t++) {
				int operation = sc.nextInt();
				switch (operation) {
				case 0: //0일때
					if(heap.size()-1 < 1) 
						System.out.println(0);
					else 
						System.out.println(removeNode() + " ");
					break;
				default: //디폴트 값으로
						insertNode(operation); //넣어준다
					break;
				}
			}


	}
	
	public static void insertNode(int value) {
		heap.add(value);
		
		int level = heap.size()-1; //노드 인덱스 값 (맨마지막 자리)에서 부모노드로 순회하면서 자리 이동시키기
		while(level>1&& heap.get(level)>heap.get(level/2)) {
			int temp = heap.get(level/2);
			heap.set(level/2, heap.get(level)); //heap배열의 level/2 /부모노드 위치에 더 큰값을 저장
			heap.set(level, temp); 
			
			level /= 2; // 계속 나눠가면서 전체 노드 순회
		}
		
	}
	
	public static int removeNode() {
		//일단 heap이 비어있는지 체크
//		if(heap.size()-1 < 1) {
//			return 0;
//		}
		
		//어차피 자리 바꿔줘서 1에 있는 노드가 루트노드
		int node = heap.get(1); //삭제할 노드값을 일단 저장해놓고 
		
		heap.set(1, heap.get(heap.size()-1)); //맨 마지막 자식노드를 위로 끓어 올려.
		heap.remove(heap.size()-1); // heap배열 크기 하나 줄여주기.
		
		//그러고 다시 순회하면서 자리 잡아주기. //배열 자체가 줄어서 idx값들을 기억하며 순회.
		int idx = 1; //root의 인덱스 값
		while((idx*2)<heap.size()) {
			int max = heap.get(idx*2);//왼쪽 자식노드
			int maxIdx = idx*2;//그 인덱스 값을 기억
			
			//오른쪽 자식노드가 왼쪽 자식노드보다 크면
			if((idx*2+1)<heap.size() && max < heap.get(idx*2+1)) {
				max = heap.get(idx*2+1);
				maxIdx = idx*2+1;
			}
			
			//부모노드가 크면 break
			if(heap.get(idx) > max) {
				break;
			}
			
			int temp = heap.get(idx);
			heap.set(idx, max);//idx에 max를 넣어주기
			heap.set(maxIdx, temp); //maxIdx자리에 temp 넣고
			idx = maxIdx;
		
		}
		
		//저장해 뒀던 가장 큰 값 출력.
		return node;
		
	}
	
}
