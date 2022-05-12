package Apr_3rd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11724_연결요소의개수 {
	static int n, m;
	static int[] p;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = new int[n+1];
		
		for(int i = 0; i<n+1; i++) {
			p[i] = i;
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x, y);
		}
		
		int ans = 0;
		int[] cnt = new int[n+1];
		for(int i = 1; i<=n; i++) {
			cnt[findSet(i)]++;
		}
		
		for(int i = 1; i<=n; i++) {
			if(cnt[i] >0) ans++;
		}
		
		System.out.println(ans);
	}

	static int findSet(int x) {
		if (x == p[x]) return x;
		else return findSet(p[x]);
	}

	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}
