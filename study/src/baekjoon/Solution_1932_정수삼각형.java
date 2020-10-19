package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1932_정수삼각형 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] tri = new int[(n*(n+1))/2+1];
		int[] mem = new int[(n*(n+1))/2+1];
		int index = 1;
		int answer = 0;
		for(int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			for(String input : inputs) {
				mem[index] = Integer.valueOf(input);
				tri[index++] = Integer.valueOf(input);
			}
		}
		int floor = 1;
		int count = 1;
		for(int i = 1 ; i < (n-1)*n/2+1; i++) {
			mem[i+floor] = Math.max(mem[i+floor], mem[i]+tri[i+floor]);
			mem[i+floor+1] = Math.max(mem[i+floor+1], mem[i]+tri[i+floor+1]);
			if(answer < Math.max(mem[i+floor], mem[i+floor+1])) answer = Math.max(mem[i+floor], mem[i+floor+1]);
			if(floor == count) {
				floor++;
				count = 1;
			}else {
				count++;
			}
		}
		System.out.println(answer);
	}

}
