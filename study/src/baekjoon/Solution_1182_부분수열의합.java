package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1182_부분수열의합 {

	static boolean visit[];
	static int num[], answer, target;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		visit = new boolean[Integer.parseInt(input[0])];
		num = new int[Integer.parseInt(input[0])];
		target = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(input[i]);
		}
		answer = 0;
		for (int i = 1; i < num.length+1; i++) {
			comb(0, 0, i);
		}
		System.out.println(answer);
	}

	public static void comb(int start, int count, int r) {
		if (count == r) {
			int sum = 0;
			for (int i = 0; i < visit.length; i++) {
				if (visit[i])
					sum += num[i];
			}
			if (sum == target)
				answer++;

			return;
		}
		for (int i = start; i < num.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				comb(i + 1, count + 1, r);
				visit[i] = false;
			}
		}
	}

}
