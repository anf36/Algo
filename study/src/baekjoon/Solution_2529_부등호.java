package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2529_부등호 {

	static int N, numbers[];
	static char[] signs;
	static boolean[] check;
	static String max, min;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		setInput();
		for (int i = 0; i < numbers.length; i++) {
			check[i] = true;
			sb.append(i);
			solve(i, 1, 0);
			sb.delete(sb.length()-1, sb.length());
			check[i] = false;
		}
		System.out.println(max);
		System.out.println(min);
	}

	private static void setInput() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		signs = br.readLine().replace(" ", "").toCharArray();
		numbers = new int[10];
		check = new boolean[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		max = "";
		min = "";
		for (int i = 0; i < N + 1; i++) {
			max += 0;
			min += 9;
		}
		sb = new StringBuilder();
	}

	private static void solve(int currentNumber, int count, int currentSignIndex) {
		if (count == N + 1) {
			String answer = sb.toString();
			if (max.compareTo(answer) < 0)
				max = answer;
			if (min.compareTo(answer) > 0)
				min = answer;
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!check[i] && signCheck(currentNumber, signs[currentSignIndex], i)) {
				check[i] = true;
				sb.append(i);
				solve(i, count + 1, currentSignIndex + 1);
				sb.delete(sb.length()-1, sb.length());
				check[i] = false;
			}
		}
	}

	private static boolean signCheck(int currentNumber, char sign, int nextNumber) {
		if (sign == '<') {
			return currentNumber < nextNumber;
		} else {
			return currentNumber > nextNumber;
		}
	}
}
