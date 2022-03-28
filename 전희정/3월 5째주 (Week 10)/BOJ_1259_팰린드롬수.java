import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259_팰린드롬수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String strNum = br.readLine();
			int len = strNum.length();
			int num = Integer.parseInt(strNum);
			// 0이 입력되면 종료
			if (num == 0)
				break;
			
			boolean flag = true;
			// 절반만큼 앞이랑 뒤랑 비교
			for (int i = 0; i < len / 2; i++) {
				if (strNum.charAt(i) != strNum.charAt(len - 1 - i)) {
					flag = false;
					break;
				}
			}
			sb.append(flag ? "yes" : "no").append("\n");
		}
		System.out.println(sb);
	}
}
