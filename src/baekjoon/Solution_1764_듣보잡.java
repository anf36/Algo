package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution_1764_듣보잡 {

	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		N = Integer.parseInt(input.split(" ")[0]);
		M = Integer.parseInt(input.split(" ")[1]);
		HashSet<String> noListen = new HashSet<>();
		ArrayList<String> noListenNoSee = new ArrayList<>();
		for(int i =0 ; i < N;i++) {
			noListen.add(br.readLine());
		}
		
		for(int i = 0 ; i < M;i ++) {
			input = br.readLine();
			if(noListen.contains(input)) {
				noListenNoSee.add(input);
			}
		}
		Collections.sort(noListenNoSee);
		System.out.println(noListenNoSee.size());
		for(String Idiot : noListenNoSee) {
			System.out.println(Idiot);
		}
				
	}

}
