package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_16719_ZOAC {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		boolean[] selected = new boolean[input.length];
		String min = "";
		int pivot = -1;
		while (min.length() != input.length) {
			min += "[";
			pivot = -1;
			for (int i = 0; i < input.length; i++) {
				if (selected[i])
					continue;
				selected[i] = true;
				String current = makeString(input, selected);
				if (current.compareTo(min) < 0 || min.contains("[")) {
					min = current;
					pivot = i;
				}
				selected[i] = false;

			}
			selected[pivot] = true;
			System.out.println(min);
		}

	}
	static String makeString(char[] input, boolean[] selected) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length; i++) {
			if (selected[i])
				sb.append(input[i]);
		}
		return sb.toString();
	}

}
