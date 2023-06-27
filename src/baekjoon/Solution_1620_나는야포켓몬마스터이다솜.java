package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		Map<Integer, String> numberToName = new HashMap<>();
		Map<String, Integer> nameToNumber = new HashMap<>();
		
		for(int i = 1 ; i <= N; i++) {
			String pocketmon = br.readLine();
			numberToName.put(i, pocketmon);
			nameToNumber.put(pocketmon, i);
		}
		
		for(int i = 0; i < M; i++) {
			String problem = br.readLine();
			if(problem.matches("[0-9]+")) {
				sb.append(numberToName.get(Integer.parseInt(problem)));
				sb.append("\n");
			}else {
				sb.append(nameToNumber.get(problem));
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
