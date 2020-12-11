package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_5676_음주코딩2 {

	static class Tree {
		char mulArr[]; // 트리를 저장하는 배열  {1,2,3,4} => {, +, +, + , +, +, +, +}
		int indexArr[]; // leaf node의 인덱스를 저장하는 배열

		Tree() {
			mulArr = new char[array.length * 4];
			indexArr = new int[array.length];
		}

		char init(int start, int end, int node) {
			if (start == end) {
				indexArr[start] = node;
				return mulArr[node] = array[start];
			}

			int mid = (start + end) / 2;
			return mulArr[node] = multiply(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
		}

		char getSign(int start, int end, int node, int left, int right) {
			if (left > end || right < start) {
				return '+';
			}
			if (left <= start && end <= right) {
				return mulArr[node];
			}
			int mid = (start + end) / 2;
			return multiply(getSign(start, mid, node * 2, left, right),	getSign(mid + 1, end, node * 2 + 1, left, right));
		}

		// bottom up 으로 짜기
		void setSign(int start, int end, int node) {
			if (node == 0)
				return;
			mulArr[node] = multiply(mulArr[node * 2], mulArr[node * 2 + 1]);

			setSign(start, end, node / 2);

		}

		char multiply(char a, char b) {
			if (a == zero || b == zero)
				return zero;
			if (a != b)
				return minus;
			return plus;
		}

		@Override
		public String toString() {
			return Arrays.toString(mulArr);
		}

	}

	static int N, K;
	static char[] array;
	static char plus = '+';
	static char minus = '-';
	static char zero = '0';
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/I.in.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while (true) {
			input = br.readLine();
			if (input == null || input.length() == 0) {
				break;
			}
			N = Integer.parseInt(input.split(" ")[0]);
			K = Integer.parseInt(input.split(" ")[1]);
			sb = new StringBuilder();
			array = new char[N];
			input = br.readLine();
			String[] temp = input.split(" ");
			for (int i = 0; i < N; i++) {
				array[i] = toSign(Integer.parseInt(temp[i]));
			}
			Tree tree = new Tree();
			tree.init(0, array.length - 1, 1);
			for (int i = 0; i < K; i++) {
				command(br.readLine(), tree);
			}
			System.out.println(sb.toString());
		}
		br.close();
	}

	private static void command(String readLine, Tree tree) {
		char commandType = readLine.split(" ")[0].charAt(0);
		int firstParam = Integer.parseInt(readLine.split(" ")[1]);
		int secondparam = Integer.parseInt(readLine.split(" ")[2]);

		if (commandType == 'C') {
			if (array[firstParam - 1] != toSign(secondparam)) {
				tree.mulArr[tree.indexArr[firstParam - 1]] = toSign(secondparam); // 젤 밑에꺼 갱신
				tree.setSign(0, array.length - 1, tree.indexArr[firstParam - 1] / 2); // 젤밑에꺼 바로위 부모부터 세팅 시작
				// array[firstParam - 1] = toSign(secondparam);
			}
		} else {
			sb.append(tree.getSign(0, array.length - 1, 1, firstParam - 1, secondparam - 1));
		}
	}

	public static char toSign(int num) {
		if (num < 0)
			return minus;
		else if (num == 0)
			return zero;
		else
			return plus;
	}

}
