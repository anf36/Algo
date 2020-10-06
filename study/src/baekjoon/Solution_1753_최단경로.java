package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_1753_최단경로 {

	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int V = Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[1]);
		int K = Integer.parseInt(br.readLine());
		List<Edge>[] adj = new LinkedList[V+1];
		int[] d = new int[V + 1];
		for(int i = 0 ; i < V+1 ; i++) {
			adj[i] = new LinkedList<>();
		}
		for (int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			int weight = Integer.parseInt(input[2]);
			adj[from].add(new Edge(to, weight));
		}
		dijkstra(adj, d, K);
		for (int i = 1; i < d.length; i++) {
			System.out.println(d[i] == INF ? "INF" : d[i]);
		}
	}

	static void dijkstra(List<Edge>[] graph, int[] d, int start) {
		Arrays.fill(d, INF);
		boolean[] visit = new boolean[d.length];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		d[start] = 0;
		pq.add(new Edge(start, 0));
		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			int index = current.to;
			if (visit[index])
				continue;
			visit[index] = true;
			for (Edge edge : graph[index]) {
				if (d[index] + edge.weight < d[edge.to]) {
					d[edge.to] = d[index] + edge.weight;
					pq.add(new Edge(edge.to, d[edge.to]));
				}
			}
		}
	}
}
