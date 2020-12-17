package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_11725_트리의부모찾기 {

	static class Node{
		ArrayList<Integer> children;
		
		Node(){
			children = new ArrayList<>();
		}
		
		void put(int child){
			children.add(child);
		}
	}
	
	static Node[] edge;
	static int[] parents;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nodeNumber = Integer.parseInt(br.readLine());
		edge = new Node[nodeNumber+1];
		parents = new int[nodeNumber+1];
		visit = new boolean[nodeNumber+1];
		for (int i = 0; i < nodeNumber - 1; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			if(edge[a] == null) edge[a] = new Node();
			if(edge[b] == null) edge[b] = new Node();
			edge[a].put(b);
			edge[b].put(a);
		}
		visit[1] = true;
		findChild(1);
		for(int i = 2; i < parents.length;i++) {
			System.out.println(parents[i]);
		}
	}
	static void findChild(int parent) {
		for(int child : edge[parent].children) {
			if(!visit[child]) {
				parents[child]=parent;
				visit[child] = true;
				findChild(child);
			}
		}
	}
}
