package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_16112_5차전직 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		long k = Integer.parseInt(input[1]);
		long sum = 0;
		int activated = 0;
		long[] stones = new long[n];
		input = br.readLine().split(" ");
		for(int i = 0 ; i < stones.length; i++) {
			stones[i] = Long.parseLong(input[i]);
		}
		Arrays.sort(stones);
		for(int i = 0 ; i < stones.length; i++) {
			sum += stones[i] * activated;
			if(k > activated)	activated++;
			
		}
		System.out.println(sum);
		
	}

}
