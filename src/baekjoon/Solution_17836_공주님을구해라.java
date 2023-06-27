package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_17836_공주님을구해라 {

	static class Force {
		int i;
		int j;
		int time;

		Force(int i, int j, int time) {
			this.i = i;
			this.j = j;
			this.time = time;
		}

	}

	static int N, M, T;
	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		T = Integer.parseInt(input[2]);
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		int answer = bfs(map);
		System.out.println(answer == -1 ? "Fail" : answer);

	}

	static int bfs(int[][] map) {
		Queue<Force> queue = new LinkedList<>();
		queue.offer(new Force(0, 0, 0));
		boolean[][] visit = new boolean[N][M];
		visit[0][0] = true;
		int time = Integer.MAX_VALUE / 2;
		while (!queue.isEmpty()) {
			Force curr = queue.poll();
			if (curr.time >= T)
				break;
			for (int d = 0; d < 4; d++) {
				int nexti = curr.i + di[d];
				int nextj = curr.j + dj[d];
				if (isLocatedIn(nexti, nextj) && !visit[nexti][nextj]) {
					if (nexti == N - 1 && nextj == M - 1) {
						time = Math.min(time, curr.time + 1);
						queue.clear();
					}
					if (map[nexti][nextj] == 0) {
						queue.offer(new Force(nexti, nextj, curr.time + 1));
						visit[nexti][nextj] = true;
					} else if (map[nexti][nextj] == 2) {
						time = Math.min(time, curr.time + 1 + (N - 1 - nexti) + (M - 1 - nextj));
					}
				}
			}
		}
		if (time > T)
			time = -1;
		return time == Integer.MAX_VALUE / 2 ? -1 : time;
	}

	static boolean isLocatedIn(int i, int j) {
		if (i < 0 || i >= N)
			return false;
		if (j < 0 || j >= M)
			return false;
		return true;
	}

}
