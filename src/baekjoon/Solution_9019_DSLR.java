package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_9019_DSLR {

	static class Register {
		int d1;
		int d2;
		int d3;
		int d4;
		int n;

		Register(int num) {
			this.d1 = num / 1000;
			this.d2 = (num / 100)%10;
			this.d3 = (num / 10) %10;
			this.d4 = num % 10;
			this.n = num;
		}

		int inputCommand(char command) {
			switch (command) {
			case 'D':
				return getD();
			case 'S':
				return getS();
			case 'L':
				return getL();
			case 'R':
				return getR();
			default:
				return -1;
			}
		}

		int getD() {
			return (n * 2) % 10000;
		}

		int getS() {
			return n == 0 ? 9999 : n - 1;
		}

		int getL() {
			return d2 * 1000 + d3 * 100 + d4 * 10 + d1;
		}

		int getR() {
			return d4 * 1000 + d1 * 100 + d2 * 10 + d3;
		}
	}

	static char[] command = { 'D', 'S', 'L', 'R' };
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			solve(A,B);
		}
		System.out.println(sb.toString());
	}

	public static void solve(int A, int B) {
		Queue<String> queue = new LinkedList<String>();
		queue.add(" "+A);
		boolean visit[] = new boolean[10000];
		visit[A] = true;
		while(!queue.isEmpty()) {
			String stackedCommand = queue.peek().split(" ")[0];
			int currentNumber = Integer.parseInt(queue.poll().split(" ")[1]);
			for(int i = 0 ; i< 4; i++) {
				Register r = new Register(currentNumber);
				int convertedNumber = r.inputCommand(command[i]);
				if(!visit[convertedNumber]) {
					if(convertedNumber == B) {
						sb.append(stackedCommand+command[i]+"\n");
						return;
					}
					queue.add(stackedCommand+command[i]+" "+convertedNumber);
					visit[convertedNumber]=true;
				}
			}
		}
	}

}
