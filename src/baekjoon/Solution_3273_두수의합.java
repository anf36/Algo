package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_3273_두수의합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] nums = new int[n];
		for(int i = 0 ; i < n; i++) {
			nums[i] = Integer.valueOf(input[i]);
		}
		int target = Integer.parseInt(br.readLine());
		int answer = 0;
		int left = 0;
		int right = n - 1;
		Arrays.sort(nums);
		while(true) {
			if(left >= right) break;
			
			if(nums[left] + nums[right] == target) {
				answer++;
				left++;
				right--;
			}else if(nums[left] + nums[right] > target) {
				right--;
			}else {
				left++;
			}
		}
		System.out.println(answer);
	}

}
