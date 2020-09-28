package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2003_수들의합2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n  = Integer.parseInt(input[0]);
		int target = Integer.parseInt(input[1]);
		int[] array = new int[n];
		input = br.readLine().split(" ");
		for(int i = 0 ; i < n ; i++) {
			array[i] = Integer.parseInt(input[i]);
		}
		int start = 0; int end = 0;
		int sum = array[0];
		int count = 0;
		while(start != n) {
			if(sum == target) {
				count++;
				sum -= (array[start++]);
				if(end < n-1) {
					sum += (array[++end]);					
				}
			}else if(sum > target){
				sum -= array[start++];
			}else {
				if(end < n-1) {
					sum += array[++end];
				}else {
					break;
				}
			}
		}
		System.out.println(count);
	}

}
