package week07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class boj1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n];

		int repeat = 0;
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
			check: for (int j = 0; j < i; j++) {
				if (words[j].equals(words[i])) {
					words[j] = "-1";
					repeat += 1;
					break check;
				}
			}
		}
		// 중복삭제
		String[] word = new String[n - repeat];
		int[] wordLength = new int[n - repeat];
		int wordIndex = 0;
		for (int i = 0; i < n; i++) {
			if (words[i] != "-1") {
				word[wordIndex++] = words[i];
			}
		}
		
		// 글자순 정렬
		Arrays.sort(word);

		// 글자 길이 순 카운팅 정렬
		int maxv = 0;
		for (int i = 0; i < n - repeat; i++) {
			wordLength[i] = word[i].length();
			maxv = (maxv > wordLength[i]) ? maxv : wordLength[i];
		}

		// 글자 길이 세고
		int[] counts = new int[maxv + 1];
		for (int i = 0; i < n-repeat; i++) {
			counts[wordLength[i]] += 1;
		}
		
		// 누적합으로 변환
		for (int i=1; i<=maxv; i++) {
			counts[i] += counts[i-1];
		}
		
		String[] wordSorted = new String[n-repeat];
		int[] test = new int[n-repeat];
		
		for (int i=n-1-repeat; i>=0; i--) {
			wordSorted[--counts[wordLength[i]]] = word[i];
		}
		
		for (int i = 0; i < n-repeat; i++) {
			System.out.println(wordSorted[i]);
		}
	}

}
