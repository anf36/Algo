package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1965_상자넣기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int[] boxes = new int[N];
		String[] input = br.readLine().split(" ");
		int[] memory = new int[N];
		int answer = 1;
		for(int i = 0 ; i < N; i++) {
			boxes[i] = Integer.valueOf(input[i]);
			memory[i] = 1;
		}
		for(int i = 1; i < N; i++) {
			int curBox = boxes[i];
			for(int j = 0 ; j < i; j++) {
				int prevBox = boxes[j];
				if(prevBox < curBox) {
					memory[i] = Math.max(memory[i], memory[j]+1);
				}
			}
			answer = Math.max(answer, memory[i]);
		}
		System.out.println(answer);
	}

}