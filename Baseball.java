import java.text.DecimalFormat;
import java.util.Scanner;

//Author: James Burger
//Program takes information from user to calculate batting stats

public class Baseball {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String atBatPrompt = "How many times was your player at bat?: ";
		int atBat = 0;
		System.out.println("Welcome to the Burger Baseball Bananza!!!");
		System.out.println("Would you like to calculate your player's stats? y/n");
		//userChoice method validates user's input and makes sure it's only a y or n
		String choice = userChoice(scan);
		
		while (choice.equalsIgnoreCase("y")) {
			//The atBat int is verified by the getInt method so that the user may only enter numbers
			atBat = getInt(scan, atBatPrompt);
			System.out.println("Please enter the results of each of their turns at bat!");
			System.out.println("0 = Out, 1 = Single, 2 = Double, 3 = Triple, 4 = Home Run :");
			//The batterData method enters the user's report of the batter's stats into an array, which is 
			//initialized in main as badDat
			int[] batDat = batterData(atBat);
			//The batAverage and slugPercent methods take the batDat array and the atBat variable to determine
			//the  player's stats
			batAverage(batDat, atBat);
			slugPercent(batDat, atBat);
			//These are displayed and the user is asked if they'd like to go again
			System.out.println("Would you like to calculate another player's stats?");
			choice = userChoice(scan);
		}
		System.out.println("Later gator!!!");
	}

	public static int[] batterData(int atBat) {
		Scanner scan = new Scanner(System.in);
		int[] batResult = new int[atBat];
		int batCount = 0;
		//For loop initializes each index space of the array with the user's input. Index length is determined
		//by atBat
		for (int i = 0; i < atBat; ++i) {
			System.out.println("Result for at bat number " + (i + 1));
			batResult[i] = getInt(scan, "", 0, 4); // getInt prevents user from entering anything but the 
			//digits they are prompted to enter
		}

		return batResult;
	}

	public static double slugPercent(int[] stats, int atBat) {
		double temp = 0;
		for (int i = 0; i < atBat; ++i) {
			temp += stats[i];
			temp = temp / atBat;

		}
		System.out.print("Slugging Percent is : ");
		System.out.printf("%.3f", temp);
		System.out.println();

		return temp;
	}

	public static double batAverage(int[] stats, int atBat) {
		double temp1 = 0;
		for (int j = 0; j < atBat; ++j) {
			if (stats[j] > 0) {
				temp1 += 1;
			}
			temp1 = temp1 / atBat;
		}
		System.out.print("Your player's batting average is : ");
		System.out.printf("%.3f", temp1);
		System.out.println();
		return temp1;

	}

	public static int getInt(Scanner scan, String prompt)

	{
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (scan.hasNextInt()) {
				i = scan.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			scan.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	public static int getInt(Scanner scan, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(scan, prompt);
			if (i < min)
				System.out.println("Error! Number must be " + min + " or greater.");
			else if (i > max)
				System.out.println("Error! Number must be " + max + " or less.");
			else
				isValid = true;
		}
		return i;
	}

	public static String userChoice(Scanner scan) {
		String s = scan.nextLine();
		while (!s.equalsIgnoreCase("y") && !s.equalsIgnoreCase("n")) {
			System.out.println("Please only enter 'y' or 'n':");
			s = scan.next();
		} 
		//System.out.println("Great!s");
			return s;
		
	}
	
}
