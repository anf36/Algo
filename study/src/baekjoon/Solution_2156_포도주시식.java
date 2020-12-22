package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2156_포도주시식 {

	static int N, amounts[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		amounts = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			amounts[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(solution());
	}

	private static int solution() {
		int[] noncontinuous = new int[N + 1];
		int[] continuous = new int[N + 1];
		int answer;
		if (N == 1) {
			return amounts[1];
		} else if (N == 2) {
			return amounts[1] + amounts[2];
		} else {

			noncontinuous[1] = amounts[1];
			noncontinuous[2] = Math.max(amounts[1], amounts[2]);
			continuous[1] = amounts[1];
			continuous[2] = amounts[1] + amounts[2];
			noncontinuous[3] = Math.max(amounts[1] + amounts[3], continuous[2]);  
			continuous[3] = amounts[2] + amounts[3];
			answer= Math.max(noncontinuous[3], continuous[3]);
			for (int i = 4; i <= N; i++) {
				int max = 0;
				for (int j = 1; j <= i - 2; j++) {
					max = Math.max(max, continuous[j]);
				}
				noncontinuous[i] = Math.max(max + amounts[i], noncontinuous[i - 2] + amounts[i]);
				continuous[i] = Math.max(noncontinuous[i - 1] + amounts[i], continuous[i - 2] + amounts[i]);
				answer = Math.max(answer, continuous[i]);
				answer = Math.max(answer, noncontinuous[i]);
			}
		}
		return answer;
	}

}
