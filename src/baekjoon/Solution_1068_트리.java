package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1068_트리 {

	static class Node{
		ArrayList<Integer> children = new ArrayList<>();
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nodeNumber = Integer.parseInt(br.readLine());
		int rootIndex = 0;
		Node[] nodes = new Node[nodeNumber];
		boolean[] visit = new boolean[nodeNumber]; 
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < nodeNumber; i++) {
			if(input[i].equals("-1")) {
				rootIndex = i;
			}else {
				if(nodes[Integer.parseInt(input[i])] == null) {
					nodes[Integer.parseInt(input[i])] = new Node();
				}
				nodes[Integer.parseInt(input[i])].children.add(i);
			}
		}
		int answer = 0;
		int delIndex = Integer.parseInt(br.readLine());
		Queue<Node> queue =  new LinkedList<>();
		
		if(rootIndex != delIndex) {
			queue.add(nodes[rootIndex]);
			visit[rootIndex] = true;
		}
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int addrChildren = 0;
			if(cur == null) {
				answer++;
				continue;
			}
			for(int child : cur.children) {
				if(!visit[child] && child != delIndex) {
					queue.offer(nodes[child]);
					visit[child] = true;
					addrChildren++;
				}
			}
			if(addrChildren==0) answer++;
		}
		System.out.println(answer);
		
	}

}
