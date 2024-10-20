package Lab1;

import java.util.Scanner;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	public char encryptChar(char c) {
		try {
			int digit = Integer.parseInt("" + c);
			digit = Math.abs((digit + n) % 10);
			return (char) ('0' + digit);
		} catch (Exception e) {
			return ALPHABET[(c + n) % 26];
		}
	}

	public char decryptChar(char c) {
		try {
			int digit = Integer.parseInt("" + c);
			digit = Math.abs((digit - n) % 10);
			return (char) ('0' + digit);
		} catch (Exception e) {
			return ALPHABET[(c - n) % 26];
		}

	}

	public String encrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result += encryptChar(input.charAt(i));
		}
		return result;
	}

	public String decrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result += decryptChar(input.charAt(i));
		}
		return result;
	}

//	Task 4
	public void readFromConsole() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Type your text that you want to encrypt");
		String encryptInput = sc.nextLine();
		System.out.println("Your encrypt text is: " + encrypt(encryptInput));
		
		System.out.println("Type your text that you want to decrypt");
		String decryptInput = sc.nextLine();
		System.out.println("Your decrypt text is: " + decrypt(decryptInput));
	}
	
	public static void main(String[] args) {
		MyCaesar mc = new MyCaesar(2);
		System.out.println(mc.encrypt("TOIDANGDIHOC123"));
		System.out.println(mc.decrypt(mc.encrypt("TOIDANGDIHOC123")));
		mc.readFromConsole();
	}
}
