package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_2812_크게만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Integer> st = new Stack<>();
		int N = Integer.valueOf(input.split(" ")[0]);
		int K = Integer.valueOf(input.split(" ")[1]);
		StringBuilder sb = new StringBuilder(br.readLine());
		int count = 0;
		for(int i = 0 ; i < N; i++) {
			if(st.isEmpty()) {
				st.push(sb.charAt(i)-'0');
			}else {
				//count 초과하지 않는 선에서 자기보다 작은 앞 숫자들 계속 지우기
				while(!st.isEmpty() && st.peek() < sb.charAt(i) -'0' && count < K) {
					st.pop();
					count++;
				}
				st.push(sb.charAt(i) - '0');
			}
		}
		//마지막 지울 수 있는 카운트 만큼 뒤에서부터 지워주기
		while(count != K) {
			count++;
			st.pop();
		}
		String answer = st.toString().replaceAll("[\\[\\],\\s]", "");
		System.out.println(answer);
	}

}
