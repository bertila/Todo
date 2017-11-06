package UI;

import java.time.LocalDate;
import java.util.Scanner;

import models.InputType;

public class GetInput {

	Scanner sc = new Scanner(System.in);

	public String getKeyboard(InputType type) {
		String out="";

		if (type.equals(InputType.STRING)) {
			out = keyboardString();
		}
		else if (type.equals(InputType.INTEGER)){
			out = keyboardInteger();
		}
		else if (type.equals(InputType.DATE)){
			out = keyboardDate();
		}
		return out;
	}

	private String fromKeyboard() {
		String output="";
		String entry ="";

		do {
			try
			{
				entry =sc.nextLine();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				break;
			}
		} while (entry =="");

		output=output+entry ;
		return output;
	}

	private String keyboardString() {
		return fromKeyboard();
	}

	private String keyboardDate() {
		LocalDate date =null;
		String input = fromKeyboard();

		try {
			date= LocalDate.parse(input);
			return date.toString();

		} catch (Exception e) { 
			System.out.println("Felaktigt datum (åååå-mm-dd)");
			return null;
		}
	}

	private String keyboardInteger() {
		String input = fromKeyboard();
		int intOut;

		try {
			intOut = Integer.parseInt(input);
			return Integer.toString(intOut);
		}
		catch (Exception e)
		{
			System.out.println("Felaktigt värde");
			return "-1";
		}
	}
}

