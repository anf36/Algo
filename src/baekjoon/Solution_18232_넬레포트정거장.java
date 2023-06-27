package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution_18232_넬레포트정거장 {
	static int N, M, S, E;
	static Map<Integer, List<Integer>> jumpInfo;

	public static void main(String[] args) throws Exception {
		_setInput();
		int arrivalTime = bfs();
		System.out.println(arrivalTime);
	}

	private static void _setInput() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		jumpInfo = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (!jumpInfo.containsKey(x)) {
				ArrayList<Integer> pointList = new ArrayList<>();
				pointList.add(y);
				jumpInfo.put(x, pointList);
			} else {
				jumpInfo.get(x).add(y);
			}
			
			if (!jumpInfo.containsKey(y)) {
				ArrayList<Integer> pointList = new ArrayList<>();
				pointList.add(x);
				jumpInfo.put(y, pointList);
			} else {
				jumpInfo.get(y).add(x);
			}
		}
	}

	private static int bfs() {
		HashSet<Integer> checkedPoint = new HashSet<>();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(S);
		checkedPoint.add(S);
		int time = 0;
		while (!queue.isEmpty()) {
			int timeCycle = queue.size();
			time++;
			for (int i = 0; i < timeCycle; i++) {
				int next = queue.poll();
				if (next != 1) {
					if (next - 1 == E)
						return time;
					if (!checkedPoint.contains(next - 1)) {
						queue.add(next - 1);
						checkedPoint.add(next - 1);

					}
				}
				if (next != N) {
					if (next + 1 == E)
						return time;
					if (!checkedPoint.contains(next + 1)) {
						queue.add(next + 1);
						checkedPoint.add(next + 1);
					}
				}
				if (jumpInfo.containsKey(next)) {
					for (int jumpPoint : jumpInfo.get(next)) {
						if (jumpPoint == E)
							return time;
						if (!checkedPoint.contains(jumpPoint)) {
							queue.add(jumpPoint);
							checkedPoint.add(jumpPoint);
						}
					}
				}
			}
		}
		return -1;
	}
}
