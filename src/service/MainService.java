package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import datastr.MyStack;

public class MainService {

    public static void main(String[] args) throws FileNotFoundException {
    	File file = new File("C:\\Users\\annap\\git\\DataStr_md1_1\\src\\service\\example1.java");
		Scanner input = new Scanner(file);

		int lineCounter = 0;
		boolean inBlockComment = false;

		while (input.hasNextLine()) {
			String line = input.nextLine();
			lineCounter++;

			MyStack<Character> stack = new MyStack<>();
			boolean isValid = true;

			int i = 0;
			while (i < line.length()) {
				if (!inBlockComment && i + 1 < line.length()) {
					if (line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
						inBlockComment = true;
						i += 2;
						continue;
					}
					if (line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
						break;
					}
				}
				if (inBlockComment && i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
					inBlockComment = false;
					i += 2;
					continue;
				}

				if (inBlockComment) {
					i++;
					continue;
				}

				char symbol = line.charAt(i);
				if (symbol == '(' || symbol == '[' || symbol == '{') {
					stack.push(symbol);
				} else if (symbol == ')' || symbol == ']' || symbol == '}') {
					if (stack.isEmpty()) {
						isValid = false;
						break;
					}

					char top = stack.pop();
					if ((symbol == ')' && top != '(') || (symbol == ']' && top != '[')
							|| (symbol == '}' && top != '{')) {
						isValid = false;
						break;
					}
				}

				i++;
			}
			
			if (!isValid || !stack.isEmpty()) {
				System.out.println("Sintakses kļūda " + lineCounter + ": " + line);
			}
		}

		input.close();

	}

}
