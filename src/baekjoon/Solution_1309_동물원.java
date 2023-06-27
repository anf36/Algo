package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1309_동물원 {

	static int N, Q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Q = 9901;
		System.out.println(solve());
	}

	private static int solve() {
		if (N == 1)
			return 3;
		if (N == 2)
			return 7;
		int[] answers = new int[N + 1];
		answers[1] = 3;
		answers[2] = 7;
		for (int i = 3; i <= N; i++) {
			answers[i] = (2 * answers[i - 1] + answers[i - 2]) % Q;
		}

		return answers[N];
	}

}
