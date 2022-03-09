import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BOJ_1181_단어정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		// 중복 제거하기 위해 set으로 입력
		Set<String> set = new HashSet<>();
		int max = 0;
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			int len = str.length();
			set.add(str);
			// 입력 받으면서 최대 길이 찾음
			if (len > max) {
				max = len;
			}
		}
		// set을 정렬하기 위해 list로 만들고 list 정렬
		List<String> list = new ArrayList<>(set);
		Collections.sort(list);
		
		//i를 1부터 최대길이만큼 반복하면서
		for (int i = 1; i <= max; i++) {
			// 문자열의 길이가 i랑 같으면 sb에 저장
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).length() == i) {
					sb.append(list.get(j) + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}
