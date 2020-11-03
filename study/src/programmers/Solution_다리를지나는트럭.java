package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_다리를지나는트럭 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int bridge_length = Integer.parseInt(br.readLine());
		int weight = Integer.parseInt(br.readLine());
		String input[] = br.readLine().split("[\\]\\[,]");
		int[] truck_weights = new int[input.length - 1];
		for (int i = 1; i < input.length; i++) {
			truck_weights[i - 1] = Integer.parseInt(input[i]);
		}
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int sum_weight = 0;
		int on_bridge = 0;
		int next = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < bridge_length; i++) {
			queue.offer(0);
		}

		while (next != truck_weights.length) {
			answer++;
			int passed = queue.poll();
			if(passed > 0) {
				on_bridge--;
				sum_weight -= passed;
			}
			if(truck_weights[next] + sum_weight <= weight && on_bridge < bridge_length) {
				queue.offer(truck_weights[next]);
				on_bridge++;
				sum_weight += truck_weights[next++];
			}else {
				queue.offer(0);
			}
		}
		
		
		return answer+bridge_length;
	}
}
