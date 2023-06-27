package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_11501_주식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0 ; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int stocks[] = new int[N];
			st = new StringTokenizer(br.readLine());
			int count = 0;
			while(st.hasMoreTokens()) {
				stocks[count++] = Integer.parseInt(st.nextToken());
			}
			int max = stocks[stocks.length-1];
			long benefit = 0;
			for(int i = stocks.length-1; i >= 0; i--) {
				if(max >= stocks[i]) {
					benefit += max - stocks[i];
				}else {
					max = stocks[i];
				}
			}
			System.out.println(benefit);
		}
	}

}
