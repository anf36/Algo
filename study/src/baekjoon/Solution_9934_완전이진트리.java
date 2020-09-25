package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_9934_��������Ʈ�� {

	static class Node{
		int index;
		boolean visit;
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[] buildnumbers = new int[(int) (Math.pow(2, K)-1)];
		String[] buildnumberstring = br.readLine().split(" ");
		for(int i = 0 ; i < buildnumbers.length ; i++) {
			buildnumbers[i] = Integer.parseInt(buildnumberstring[i]);
		}
		ArrayList<Integer> answer = new ArrayList<>();
		// 1. root �� ���� K--
		// 2. root �Ʒ����� �ΰ� / ���� 2^(K-1)
		// 3. K-- �ǰ� ���� 2^(0) �� ���� ���� ���̳ʽ� �÷��� �Ȱ��� �ǽ�
		int pivot = buildnumbers.length/2;
		int floor = K-2;
		int start = 0;
		answer.add(pivot);
		while(floor >=0) {
			pivot = answer.get(start);
			answer.add((int) (pivot-Math.pow(2, floor)));
			answer.add((int) (pivot+Math.pow(2, floor)));
			start++;
			if(isMatch(answer.size()+1)) {
				floor--;
			}
		}
		for(int i = 0 ; i < answer.size(); i++) {
			System.out.print(buildnumbers[answer.get(i)] + " ");
			if(isMatch(i+2)) {
				System.out.println();
			}
		}
	}
	static boolean isMatch(int number) {
		if(number != 2 && number % 2 == 1) return false;
		else if(number == 2) return true;
		else	return isMatch(number/2);
	}
}