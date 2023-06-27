package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_5676_음주코딩 {

	static int N, K;
	static char[] array;
	static char plus = '+';
	static char minus = '-';
	static char zero = '0';
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while ((input = br.readLine()).length() != 0) {
			N = Integer.parseInt(input.split(" ")[0]);
			K = Integer.parseInt(input.split(" ")[1]);
			sb = new StringBuilder();
			array = new char[N + 1];
			input = br.readLine();
			String[] temp = input.split(" ");
			for (int i = 0; i < N; i++) {
				array[i + 1] = toSign(Integer.parseInt(temp[i]));
			}
			for (int i = 0; i < K; i++) {
				command(br.readLine());
			}
			System.out.println(sb.toString());
		}
	}

	private static void command(String readLine) {
		char commandType = readLine.split(" ")[0].charAt(0);
		int firstParam = Integer.parseInt(readLine.split(" ")[1]);
		int secondparam = Integer.parseInt(readLine.split(" ")[2]);

		if (commandType == 'C') {
			array[firstParam] = toSign(secondparam);
		} else {
			sb.append(multiply(firstParam, secondparam));
		}
	}

	private static char multiply(int firstParam, int secondparam) {
		int minusCount = 0;
		for (int i = firstParam; i <= secondparam; i++) {
			if (array[i] == zero)
				return zero;
			if (array[i] == minus)
				minusCount++;
		}
		return minusCount % 2 == 0 ? plus : minus;
	}

	public static char toSign(int num) {
		if (num == 0)
			return zero;
		if (num < 0)
			return minus;
		else
			return plus;
	}

}
