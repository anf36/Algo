package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Solution_2504_괄호의값 {

	public static void main(String[] args) throws Exception {
		Stack<Character> brackets = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = (br.readLine().toCharArray());
		if (isValid(input, brackets)) {
			System.out.println(solve(input));
		} else {
			System.out.println("0");
		}
	}
	public static int solve(char[] input) {
		if(input.length == 2) {
			return input[0] == '(' ? 2 : 3;
		}
		if(input.length == 0) {
			return 0;
		}
		char left = input[0];
		int count = 0;
		int rightIndex = 0;
		for (int i = 1; i < input.length; i++) {
			if (count == 0 && isMatch(left, input[i])) {
				rightIndex = i;
				break;
			}
			if (input[i] == '(' || input[i] == '[')
				count++;
			else
				count--;
		}
		char[] lefthand = Arrays.copyOfRange(input, 1, rightIndex);
		char[] righthand = Arrays.copyOfRange(input, rightIndex+1, input.length);
		if(lefthand.length == 0)	return left =='(' ? 2+solve(righthand): 3+solve(righthand) ;
		return left =='(' ? 2*solve(lefthand) + solve(righthand) : 3 * solve(lefthand) + solve(righthand);
	}
	public static boolean isValid(char[] input, Stack<Character> brackets) {
		for (char token : input) {
			if (brackets.isEmpty()) {
				brackets.push(token);
			} else {
				if (isMatch(brackets.peek(), token)) {
					brackets.pop();
				} else {
					brackets.push(token);
				}
			}
		}
		return brackets.isEmpty();
	}
	public static boolean isMatch(char a, char b) {
		if (a == '(' && b == ')')
			return true;
		if (a == '[' && b == ']')
			return true;
		return false;
	}
}