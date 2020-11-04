package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_11057_오르막수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N == 1) System.out.println("10");
		else if(N == 2) System.out.println("55");
		else {
			ArrayList<BigInteger> answer = new ArrayList<>();
			answer.add(new BigInteger("10"));
			answer.add(new BigInteger("45"));
			BigInteger curSum = new BigInteger("55");
			int curNum = 2;
			BigInteger[] state = new BigInteger[9];
			int s = 9;
			for(int i = 0 ; i < state.length;i++) {
				state[i] = new BigInteger(""+(s-i));
			}
			while(curNum != N) {
				BigInteger base = answer.get(curNum-1);
				BigInteger next = base;
				BigInteger[] nextState = new BigInteger[9];
				nextState[0] = base;
				for(int i = 0; i < state.length-1; i++) {
					next = next.add(nextState[i].subtract(state[i]));
					nextState[i+1] = nextState[i].subtract(state[i]);
				}
				state = Arrays.copyOf(nextState, 9);
				answer.add(next);
				curSum = curSum.add(next);
				curNum++;
			}
			System.out.println(curSum.mod(new BigInteger("10007")));
		}
	}

}
