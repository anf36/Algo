package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_9329_패스트푸드상금 {

	static class Store {
		int price;
		int[] cupons;

		Store(int price, int[] cupons) {
			this.price = price;
			this.cupons = cupons;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			Store[] stores = new Store[n];
			int[] counts = new int[m + 1];
			int answer = 0;
			for (int i = 0; i < n; i++) {
				input = br.readLine().split(" ");
				int[] cupons = new int[Integer.parseInt(input[0])];
				for (int j = 0; j < cupons.length; j++) {
					cupons[j] = Integer.parseInt(input[j + 1]);
				}
				stores[i] = new Store(Integer.parseInt(input[input.length - 1]), cupons);
			}
			input = br.readLine().split(" ");
			for (int i = 0; i < input.length; i++) {
				counts[i + 1] = Integer.parseInt(input[i]);
			}
			for (int i = 0; i < stores.length; i++) {
				answer += maxvalue(stores[i], counts);
			}
			System.out.println(answer);
		}
	}
	static int maxvalue(Store stores, int[] counts) {
		int min = 101;
		for (int i = 0; i < stores.cupons.length; i++) {
			min = Math.min(min, counts[stores.cupons[i]]);
		}
		return stores.price * min;
	}
}
