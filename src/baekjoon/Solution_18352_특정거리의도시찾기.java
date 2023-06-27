package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution_18352_특정거리의도시찾기 {

	static class City {
		int num;
		Set<Integer> movable;

		City(int num) {
			this.num = num;
			movable = new HashSet<>();
		}

		void setRoad(int other) {
			movable.add(other);
		}
	}

	static BufferedReader br;
	static int N, M, K, X;

	public static void main(String[] args) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));

		_getParams();

		City[] cities = _setCities();

		PriorityQueue<Integer> answer = _getAnswer(cities);


		_print(answer);

	}

	private static City[] _setCities() throws Exception {
		City[] cities = new City[N + 1];
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			if (cities[A] == null)
				cities[A] = new City(A);
			if (cities[B] == null)
				cities[B] = new City(B);

			cities[A].setRoad(B);
		}
		return cities;
	}

	private static void _getParams() throws Exception {

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		X = Integer.parseInt(input[3]);
	}

	static PriorityQueue<Integer> _getAnswer(City[] cities) {

		Queue<Integer> queue = new LinkedList<Integer>();
		// 출발
		// 거리 1
		int distance = 0;
		queue.offer(X);
		boolean[] visited = new boolean[N + 1];
		visited[X] = true;
		while (distance != K) {

			int sameDistanceCity = queue.size();
			for (int i = 0; i < sameDistanceCity; i++) {
				int next = queue.poll();
				Iterator<Integer> iter = cities[next].movable.iterator();
				while (iter.hasNext()) {
					int possibleCity = iter.next();
					if (!visited[possibleCity]) {
						queue.add(possibleCity);
						visited[possibleCity] = true;
					}
				}
			}

			distance++;
		}

		return new PriorityQueue<>(queue);
	}

	private static void _print(PriorityQueue<Integer> answer) {
		if (answer.size() == 0 || answer == null)
			System.out.println("-1");
		else {
			while(!answer.isEmpty()) {
				System.out.println(answer.poll());
			}
		}
	}
}
