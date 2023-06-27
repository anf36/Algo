package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_13305_주유소 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] cities = new int[N];
		int[] roads = new int[N - 1];
		st = new StringTokenizer(br.readLine());
		int index = 0;
		while (st.hasMoreTokens()) {
			roads[index++] = Integer.parseInt(st.nextToken());
		}
		index = 0;
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			cities[index++] = Integer.parseInt(st.nextToken());
		}
		long cost = 0;
		long sum = 0;
		long min_gas = cities[0];
		for (int i = 0; i < roads.length; i++) {
			if (min_gas > cities[i]) {
				cost += min_gas * sum;
				min_gas = cities[i];
				sum = 0;
			}
			sum += roads[i];
		}
		cost += min_gas * sum;
		System.out.println(cost);
	}
}
