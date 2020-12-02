package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution_풍선터뜨리기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", " ");
		String[] inputList = input.split(" ");
		int[] a = new int[inputList.length];
		// int min = Integer.MAX_VALUE;
		// int minIndex = -1;
		for (int i = 0; i < inputList.length; i++) {
			a[i] = Integer.parseInt(inputList[i]);
//			if(i != 0 && a[i] < min) {
//				min = a[i];
//				minIndex = i;
//			}
		}
		System.out.println(solution(a));
	}

	static public int solution(int[] a) {
		HashSet<Integer> answerSet = new HashSet<>();
		if (a.length <= 3)
			return a.length;
		int answer = 2;
		int leftMinIndex = 0;
		int rightMinIndex = a.length - 1;
		for (int i = 1; i < a.length - 1; i++) {
			// 왼쪽값들 보다 작으면 무조건 살아남을 수 있음
			// 왼쪽값들은 검증된 값이므로 가볼 필요가 없음
			if (a[i] < a[leftMinIndex]) {
				answerSet.add(i);
				leftMinIndex = i;
			}
		}
		for (int i = a.length - 1; i >= 1; i--) {
			// 오른쪽값들 보다 작으면 무조건 살아남을 수 있음
			// 오른쪽값들은 검증된 값이므로 가볼 필요가 없음
			if (a[i] < a[rightMinIndex]) {
				answerSet.add(i);
				rightMinIndex = i;
			}
		}
		return answer + answerSet.size();
	}

//	static private  int find(int currentIndex, int[] a) {
//		int min = Integer.MAX_VALUE;
//		int minIndex = 0;
//		for(int i = currentIndex+1 ; i < a.length; i++) {
//			if(min > a[i]) {
//				min = a[i];
//				minIndex = i;
//			}
//		}
//		return minIndex;
//	}

}
