package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_11055_가장큰증가부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] array = new int[N+1]; 
		int[] sum = new int[N+1];
		
		for(int i = 1 ; i <= N; i++) {
			array[i] = Integer.parseInt(input[i-1]);
		}
		System.out.println(solution(array,sum, N));
		
	}

	private static int solution(int[] array, int[] sum, int N) {
		sum[1] = array[1];
		int max = array[1];
		for(int i = 2; i <= N; i++) {
			for(int j = 0 ; j < i; j++) {
				if(array[i] > array[j] && sum[i] < sum[j]+array[i]) {
					sum[i] = sum[j]+array[i];
				}
			}
			max=Math.max(max, sum[i]);
		}
		return max;
	}
	

}
