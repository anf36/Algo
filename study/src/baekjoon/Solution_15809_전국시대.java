package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_15809_전국시대 {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] N_M = br.readLine().split(" ");
		int N = Integer.parseInt(N_M[0]);
		int M = Integer.parseInt(N_M[1]);
		int nations[] = new int[N+1];
		int soldiers[] = new int [N+1];
		boolean check[] = new boolean[N+1];
		check[0] = true;
		for(int i = 1 ; i < nations.length; i++) {
			nations[i] = i;
			soldiers[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			String[] record = br.readLine().split(" ");
			int P = find(nations, Integer.parseInt(record[1]));
			int Q = find(nations, Integer.parseInt(record[2]));
			if (record[0].equals("1")) {
				soldiers[P] += soldiers[Q];
				soldiers[Q] = 0;
				nations[Q] = P;
			} else {
				if(soldiers[P] > soldiers[Q]) {
					soldiers[P] -= soldiers[Q];
					soldiers[Q] = 0;
					nations[Q] = P;
				}else if(soldiers[Q] > soldiers[P]) {
					soldiers[Q] -= soldiers[P];
					soldiers[P] = 0;
					nations[P] = Q;
				}else {
					soldiers[P] = 0;
					soldiers[Q] = 0;
					nations[P] = 0;
					nations[Q] = 0;
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 1 ; i <= N; i++) {
			if(soldiers[i] !=0 ) {
				list.add(soldiers[i]);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0 ; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	static int find(int[] nations, int start) {
		if(nations[start] == start)	return start;
		else {
			return find(nations, nations[start]);
		}
	}
}

