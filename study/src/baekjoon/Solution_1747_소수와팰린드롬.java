package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1747_소수와팰린드롬 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		if (n == 1 || (n!=2 && n % 2 == 0))
			n++;
		while (true) {
			if (isPalindrome(n) && isPrime(n)) {
				System.out.println(n);
				break;
			}
			n += 2;
		}
	}

	static boolean isPrime(long number) {
		if (number == 2)
			return true;
		if (number == 1)
			return false;
		if (number % 2 == 0)
			return false;
		for (int n = 3; n < number; n += 2) {
			if (number % n == 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean isPalindrome(long n) {
		String st = "" + n;
		int start = 0;
		int end = st.length() - 1;

		for (int i = 0; i < st.length() / 2; i++) {
			if (st.charAt(start + i) != st.charAt(end - i))
				return false;
		}
		return true;
	}

}
