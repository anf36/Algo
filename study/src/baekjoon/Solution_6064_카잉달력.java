package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_6064_카잉달력 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int T = Integer.parseInt(input[0]);
		int M, N, x, y;
		for (int tc = 0; tc < T; tc++) {
			input = br.readLine().split(" ");
			M = Integer.parseInt(input[0]);
			N = Integer.parseInt(input[1]);
			x = Integer.parseInt(input[2]);
			y = Integer.parseInt(input[3]);

			System.out.println(cal(M,N,x,y));
		}
	}

	private static int cal(int M, int N, int x, int y) {
		int gcd = _getGcd(M, N);
		int max = gcd * M/gcd * N/gcd;
		int d = 0;
		int answer = -1;
		while(M*d + x <= max) {
			int num = d*M + x;
			if(num % N == (y==N ? 0 : y)) {
				answer = num;
				break;
			}
			
			d++;
		}
		
		return answer;
	}
	private static int _getGcd (int M, int N) {
		int a = Math.max(M, N);
		int b = Math.min(M, N);
		while(!(a%b==0)) {
			int q = b;
			int r = a%b;
			a = q;
			b = r;
		}
		
		return b;
	}
}
