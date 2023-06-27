package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_11728_배열합치기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		int[] array1 = new int[N];
		int[] array2 = new int[M];

		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			array1[i] = Integer.parseInt(input[i]);
		}

		input = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			array2[i] = Integer.parseInt(input[i]);
		}

		int index1 = 0;
		int index2 = 0;
		while (index1 != N || index2 != M) {
			if (index1 == N) {
				sb.append(array2[index2] + " ");
				index2++;
			} else if (index2 == M) {
				sb.append(array1[index1] + " ");
				index1++;
			} else {

				if (array1[index1] > array2[index2]) {
					sb.append(array2[index2] + " ");
					index2++;
				} else {
					sb.append(array1[index1] + " ");
					index1++;
				}
			}
		}
		System.out.println(sb.toString());
	}

}
