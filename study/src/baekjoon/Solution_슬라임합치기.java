package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_슬라임합치기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] slimes = new int[N];
		st = new StringTokenizer(br.readLine());
		int count = 0;
		while (st.hasMoreTokens()) {
			slimes[count++] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		int sum = slimes[0];
		for (int i = 1; i < N; i++) {
			answer += sum * slimes[i];
			sum = sum + slimes[i];
			//System.out.println(sum + " | " + answer);
		}
		System.out.println(answer);

	}

}
