package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution_20166_문자열지옥에빠진호석이 {

	static int N, M, K;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Map<String, Integer> solved = new HashMap<>();
		String input[] = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);

		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i] = row;
			}
		}

		for (int i = 0; i < K; i++) {
			
			String favorite = br.readLine();
			
			if(!solved.containsKey(favorite)) {
				
				int pathcount = solve(map, favorite);
				solved.put(favorite,pathcount);
				sb.append(pathcount).append("\n");
				
			}else {
				sb.append(solved.get(favorite)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static int solve(char[][] map, String input) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == input.charAt(0)) {
					count += findMatched(map, input.substring(1, input.length()), i, j);
				}
			}
		}

		return count;
	}

	private static int findMatched(char[][] map, String input, int x, int y) {
		int count = 0;
		if (input.length() == 0) {
			return 1;
		}

		for (int[] next : makeDirection(x, y)) {
			if(map[next[0]][next[1]] == input.charAt(0)) {
				count+=findMatched(map, input.substring(1,input.length()), next[0], next[1]);
			}
		}

		return count;
	}

	private static int[][] makeDirection(int x, int y) {
		int[][] directions = new int[8][2];
		int[] dx = { 1, 1, 1, 0, -1, -1, -1, 0 };
		int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0) {
				nx = N - 1;
			} else if (nx >= N) {
				nx = 0;
			}

			if (ny < 0) {
				ny = M - 1;
			} else if (ny >= M) {
				ny = 0;
			}
			
			directions[i] = new int[] {nx,ny};
		}

		return directions;
	}

}
