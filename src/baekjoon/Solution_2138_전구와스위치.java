package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class Solution_2138_전구와스위치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] cur = new boolean[N];
		boolean[] target = new boolean[N];
		String[] input = br.readLine().split("");
		for (int i = 0; i < N; i++) {
			cur[i] = input[i].equals("0");
		}
		input = br.readLine().split("");
		for (int i = 0; i < N; i++) {
			target[i] = input[i].equals("0");
		}
		int answer =turn(cur,target);
		cur[0] = !cur[0];
		cur[1] = !cur[1];
		
		int convert = turn(cur,target);
		if(convert != -1) convert++;
		if(answer == -1)	System.out.println(convert);
		else if(convert == -1) System.out.println(answer);
		else System.out.println(Math.min(convert, answer));
	}
	static int turn(boolean[] cur, boolean[] target) {
		int count = 0 ;
		boolean[] temp = Arrays.copyOf(cur, cur.length);
		for(int i = 1; i < temp.length-1; i++) {
			if(temp[i-1] != target[i-1]) {
				count++;
				temp[i-1] = !temp[i-1];
				temp[i] = !temp[i];
				temp[i+1] = !temp[i+1];
			}
		}
		if(temp[temp.length-2] != target[target.length-2]) {
			temp[temp.length-2] = !temp[temp.length-2];
			temp[temp.length-1] = !temp[temp.length-1];
			count++;
		}
		if(Arrays.equals(temp, target))	return count;
		return -1;
	}

}
