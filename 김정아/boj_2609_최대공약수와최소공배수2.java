package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj_2609_최대공약수와최소공배수2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//두개의 자연수를 입력받는다
		int N1 = sc.nextInt(); 
		int N2 = sc.nextInt();
		//GCD라는 배열을 하나 만들어주고
		ArrayList<Integer> GCD = new ArrayList<>();
		GCD.add(N1);
		GCD.add(N2);
		Collections.sort(GCD); // 차례로 sort를 해준다
		for(int i = GCD.get(0); i > 0; i--) { // 공약수는 작은거로 해주면 되니까 // 이상하게 위로 올려주면 자꾸 by zero
			if(GCD.get(0)%i == 0 && GCD.get(1) % i == 0) { // 두개가 다 나눠지는 i를 출력
				System.out.println(i);// 출력
				break;
			}
		}
		for(int i = GCD.get(1); i < 100000000; i++){ // 공배수는 더 큰걸 기준으로 해주는데 이번엔 큰거로 나눠지는 i를.
            if(i % GCD.get(1) == 0 && i % GCD.get(0) ==0){
                System.out.println(i);
                break;
            }
        }

	}
}
