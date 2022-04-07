package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class study_1003_피보나치 {
	
	static int[] result= new int[41];
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		result[0]=0; result[1]=1; result[2]=1; //일단 첫 값들은  넣어줘
		
        for(int tc = 1; tc <= T; tc++){
        	
            int N=Integer.parseInt(br.readLine());
            
            if (N == 0) {
                System.out.println("1 0");
            } else if (N == 1) {
                System.out.println("0 1");
            } else {
                fibonacci(N);
                System.out.println(result[N-1]+" "+result[N]);
            }

            
        }
	}
	
	
	static int fibonacci(int n) { //피보나치
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            if(result[n]!=0){
                return result[n];
            }
            else{
                result[n]=fibonacci(n-1) + fibonacci(n-2);
                return result[n];
            }
        }
    }
}
