package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 시간이 너무 길다. 다른 코드 리뷰하기ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
// ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ

public class boj_1181_단어정렬 {

	static class word {
		char[] charArr;
		int length;

		public word(char[] charArr, int length) {
			this.charArr = charArr;
			this.length = length;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<word> wordArray = new ArrayList<>();
		// 맨앞에 깡통을 두개를 넣어주면
		// (깡통 제외한 배열)맨앞,맨뒤에 단어를 추가하는 경우를
		// 따로 처리 안해줘도 됨
		char[] emptyCharArr = {};
		wordArray.add(new word(emptyCharArr, 0));
		wordArray.add(new word(emptyCharArr, 51));
		for (int in = 0; in < N; in++) {
			char[] newIn = br.readLine().toCharArray();
			word newWord = new word(newIn, newIn.length);
			// 원래 있던 것들과 크기 비교해서 적절한 위치에 추가

			// 단어 배열의 뒤에서부터 스캔해서
			for (int scan = wordArray.size() - 1; scan >= 0; scan--) {
				// 나보다 작은 놈 찾으면 스탑
				if (wordArray.get(scan).length < newWord.length) {
					int dicCompDelta = 0;
					// 스탑한 지점 다음부터가 나와 길이가 같은 단어가 있을 수 있는 곳이다
					// 스탑한 다음 지점 단어가 나와 같은 길이이면
					// 사전비교를 해서 해당 단어가 나보다 우선이면
					// 그 다음것에 대해 반복하고
					// 해당 단어가 나보다 우선이 아니면
					// 바로 그 비교하던 단어의 지점에 나를 넣는다.
					boolean flag = false;
					do {
						dicCompDelta++;
						// 길이가 나보다 큰 놈이 나타나면 중단
						if (wordArray.get(scan + dicCompDelta).length != newWord.length) {
							break;
						}
						switch (alphabetCompare(wordArray.get(scan + dicCompDelta), newWord)) {
						case "LEFT":
							flag = true;
							break;
						case "RIGHT":
							flag = false;
							break;
						case "EQUAL":
							// 같은 단어이면 원래 거 제거
							wordArray.remove(scan + dicCompDelta);
							flag = false;
							break;
						}
					} while (flag);
					wordArray.add(scan + dicCompDelta, newWord);
					// 위치 정하고 추가했으면 스캔을 끝낸다.
					break;
				}
			}
		}

		// 출력(양끝은 깡통이므로 빼고 출력)
		for (int pIdx = 1; pIdx <= wordArray.size()-2; pIdx++) {
			StringBuilder sb = new StringBuilder();
			for (int sIdx = 0; sIdx < wordArray.get(pIdx).length; sIdx++) {
				sb.append(wordArray.get(pIdx).charArr[sIdx]);
			}
			bw.write(sb.toString() + "\n");
		}
		bw.flush();
		bw.close();
	}

	// 길이가 같을때 사전순비교
	// word1이 우선이면 0, word2가 우선이면 1, 같은 word면 2
	public static String alphabetCompare(word word1, word word2) {
		for (int wIdx = 0; wIdx < word1.length; wIdx++) {
			if (word1.charArr[wIdx] != word2.charArr[wIdx]) {
				if (word1.charArr[wIdx] < word2.charArr[wIdx]) {
					return "LEFT";
				} else {
					return "RIGHT";
				}
			}
		}
		// word1,word2가 완전히 같으면 아무거나 리턴.
		return "EQUAL";
	}
}
// End
