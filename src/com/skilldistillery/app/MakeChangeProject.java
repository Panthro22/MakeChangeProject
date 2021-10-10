package com.skilldistillery.app;

import java.util.Scanner;

public class MakeChangeProject {
	
	private static Scanner keyBoard = new Scanner(System.in);
	/*
	 * Part 1: need to prompt user/cashier to input the item price. 
	 * Part 2: need to prompt user/cashier to input the amount given to pay for item. 
	 * Part 3: Print out message to inform user/cashier that too little or exact change was given.
	 * Part 4: Build a method to break down from largest bill to smallest coin. 
	 *     4a: If statements to break the tender to give back from largest to smallest
	 *         amount... IE... not giving back 150 pennies for $1.50 over item price. 
	 * Part 5: Create a while loop allowing the cashier to continue allowing customer to
	 *         purchase items. 
	 * part 6: set customer to certain amount of cash on hand
	 *         IE(wallet/purse). 
	 *     6a: method to track customer's wallet. 
	 * Part 7: reduce amount of code in main itself.
	 */

	public static void main(String[] args) {
		boolean terminateProgram = false;
		
		do {
			
			menuOption();
			terminateProgram = terminateApplication();
		
		}while(!terminateProgram);
		System.out.println("Program shutting down....");
		keyBoard.close();
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/* 
	 * This method handles the operation of the menu options.
	 * Will also call other methods to print out borders for information being system out printed as well/\.
	 */
	public static void menuOption() {
		
		double itemPrice; // Price of Item customer is buying
		double cashGiven; // Cash the customer gave the cashier
		//int stringLength=0;
		
		
		topAndBottomBorderBuilder("Please enter the merchandise price?".length());
		leftAndRightBorderBuilder("Please enter the merchandise price?".length() ,"Please enter the merchandise price?");
		topAndBottomBorderBuilder("Please enter the merchandise price?".length());
		
		System.out.print("*\n*");
		itemPrice = keyBoard.nextDouble();
		keyBoard.nextLine();
		System.out.println("*");
		
		topAndBottomBorderBuilder("Please enter the cash amount received from the customer? ".length());
		leftAndRightBorderBuilder("Please enter the cash amount received from the customer? ".length(),"Please enter the cash amount received from the customer? ");
		topAndBottomBorderBuilder("Please enter the cash amount received from the customer? ".length());
		System.out.print("*\n*");
		cashGiven = keyBoard.nextDouble();
		keyBoard.nextLine();
		System.out.println("*");

		if (cashGiven == itemPrice) {
			topAndBottomBorderBuilder("Exact change was given!".length());
			leftAndRightBorderBuilder("Exact change was given!".length(),"Exact change was given!");
			topAndBottomBorderBuilder("Exact change was given!".length());
			//System.out.println("Exact change was given!");
		} 
		
		else if (cashGiven < itemPrice) {
			topAndBottomBorderBuilder("Please inform the customer that not enough cash was given to purchase the merchandise.".length());
			leftAndRightBorderBuilder("Please inform the customer that not enough cash was given to purchase the merchandise.".length(),"Please inform the customer that not enough cash was given to purchase the merchandise.");
			topAndBottomBorderBuilder("Please inform the customer that not enough cash was given to purchase the merchandise.".length());
			//System.out.println("Please inform the customer that not enough cash was given to purchase the merchandise.");
		} 
		
		else {
			topAndBottomBorderBuilder("System is calculating the exact change to give back to customer...".length());
			leftAndRightBorderBuilder("System is calculating the exact change to give back to customer...".length(),"System is calculating the exact change to give back to customer...");
			topAndBottomBorderBuilder("System is calculating the exact change to give back to customer...".length());
			//System.out.println("System is calculating the exact change to give back to customer...");
			topAndBottomBorderBuilder(calculateChange(itemPrice, cashGiven).length());
			leftAndRightBorderBuilder(calculateChange(itemPrice, cashGiven).length(),calculateChange(itemPrice, cashGiven));// Receipt Output
			topAndBottomBorderBuilder(calculateChange(itemPrice, cashGiven).length());
			System.out.println("");
			//System.out.println(calculateChange(itemPrice, cashGiven));

		}
		
		
		
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void topAndBottomBorderBuilder(int maxDataLength) {
		
		for( int howManyTimes = 0; howManyTimes < (maxDataLength + 4); howManyTimes++) {
			System.out.print("*");
		}
		System.out.println("");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void leftAndRightBorderBuilder(int maxDataLength, String outPrintedText) {
		
		printSpacerAndAstrik(maxDataLength);
		System.out.println("* " + outPrintedText + " *");
		printSpacerAndAstrik(maxDataLength);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void printSpacerAndAstrik(int maxDataLength) {
		System.out.print("*");
		for(int length = 0; length < maxDataLength+2; length++) {
			System.out.print(" ");
		}
		System.out.print("*");
		System.out.println("");
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * This method is to get a string response to whether or not they want to continue with the program.
	 */
	public static String getStringAnswer() {
		String userResponse;
		topAndBottomBorderBuilder("If would like to continue with the application please answer with a \"yes\", otherwise \"no\" will close the application for you. ".length());
		
		leftAndRightBorderBuilder("If would like to continue with the application please answer with a \"yes\", otherwise \"no\" will close the application for you. ".length(),"If would like to continue with the application please answer with a \"yes\","
						+ " otherwise \"no\" will close the application for you. ");
		
		leftAndRightBorderBuilder("If would like to continue with the application please answer with a \"yes\", otherwise \"no\" will close the application for you. ".length(),"Response needed: ");
		
		topAndBottomBorderBuilder("If would like to continue with the application please answer with a \"yes\", otherwise \"no\" will close the application for you. ".length());
		//System.out.println("If would like to continue with the application please answer with a \"yes\","
		//					+ " otherwise \"no\" will close the application for you. \nResponse needed: ");
		userResponse = keyBoard.nextLine();
		
		return userResponse;
		
	}
	

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static boolean terminateApplication() {
		 
		 Boolean terminateApp = false;
		 String userResponse = getStringAnswer();
		 switch(userResponse) {
		 case "yes":
		 case "Yes":
		 case "YEs":
		 case "yES":
		 case "yeS":
		 case "YES":
			 terminateApp = false;
			 break;
		 case "no":
		 case "No":
		 case "NO":
			 terminateApp = true;
			 break;
		 default:
			 System.out.println("Sorry an incorrect response was given.");
			 System.out.println("Application is continuing to run");//Need to re-loop back into get response and getting a correct answer.
			 
		 }
		 		
		return terminateApp;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Method is to handle breaking down from largest bill possible to smallest cent as needed.
	public static String calculateChange(double itemPrice, double cashGiven) {
		double totalAmountToReturn = cashGiven - itemPrice +0.005;//).005 is to round up as needed for the penny value.
		//System.out.println(totalAmountToReturn);
		String totalAmountBreakDown = "";
		// Following are the different Bill and Cents used/ accepted at this store.
		int twentyDollarBill = 0;
		int tenDollarBill = 0;
		int fiveDollarBill = 0;
		int oneDollarBill = 0;
		int quarterCent = 0;
		int dimeCent = 0;
		int nickelCent = 0;
		int pennyCent = 0;
		int howManyTimes = 0;
		
		while (totalAmountToReturn > 0.009) {
			
			if (totalAmountToReturn / 20 >=1 ) {
			//	System.out.println("its me"+totalAmountToReturn/20);
				howManyTimes = (int)(totalAmountToReturn/20);
			//	System.out.println(howManyTimes);
				totalAmountToReturn -= (20 * howManyTimes);
				
				twentyDollarBill += 1 * howManyTimes;
				
			} 
		
			else if ((totalAmountToReturn / 10) >= 1 ) {
			//	System.out.println(totalAmountToReturn/10);
				howManyTimes = (int)(totalAmountToReturn/10);
				totalAmountToReturn -= 10 * howManyTimes;
				tenDollarBill += 1 * howManyTimes;
			} 
			
			else if ((totalAmountToReturn / 5) >= 1 ) {
			//	System.out.println(totalAmountToReturn/5);
				howManyTimes = (int)(totalAmountToReturn/5);
				totalAmountToReturn -= 5 * howManyTimes;
				fiveDollarBill += 1 * howManyTimes;
			} 
			
			else if ((totalAmountToReturn / 1) >= 1 ) {
			//	System.out.println(totalAmountToReturn/1);
				howManyTimes = (int)(totalAmountToReturn/1);
				totalAmountToReturn -= 1 * howManyTimes;
				oneDollarBill += 1 * howManyTimes;
			} 
			
			else if ((totalAmountToReturn / 0.25) >= 1 ) {
				//System.out.println(totalAmountToReturn/0.25);
				howManyTimes = (int)(totalAmountToReturn/0.25);
				//System.out.println(howManyTimes);
				totalAmountToReturn -= 0.25 * howManyTimes;
				quarterCent += 1 * howManyTimes;
			} 
			
			else if ((totalAmountToReturn / 0.10) >= 1) {
			//	System.out.println(totalAmountToReturn/0.10);
				howManyTimes = (int)(totalAmountToReturn/0.10);
				totalAmountToReturn -= 0.10 * howManyTimes;
				dimeCent += 1 * howManyTimes;
			} 
			
			else if ((totalAmountToReturn / 0.05) >= 1) {
			//	System.out.println(totalAmountToReturn/0.05);
				howManyTimes = (int)(totalAmountToReturn/0.05);
				totalAmountToReturn -= 0.05 * howManyTimes;
				nickelCent += 1 * howManyTimes;
			} 
			
			else if ((totalAmountToReturn / 0.01) >= 1) {
			//	System.out.println(totalAmountToReturn/0.01);
				howManyTimes = (int)(((totalAmountToReturn)/0.01));
			//	System.out.println(howManyTimes);
				totalAmountToReturn -= 0.01 * howManyTimes;
				pennyCent += 1 * howManyTimes;
			
			}


			else {
				//System.out.println("Calculation completed ");
				totalAmountToReturn = (int)totalAmountToReturn;
			}
			
		}
		totalAmountBreakDown = convertChangeToString(twentyDollarBill, tenDollarBill, fiveDollarBill, oneDollarBill,
				quarterCent, dimeCent, nickelCent, pennyCent, itemPrice , cashGiven);
		
		
		return totalAmountBreakDown;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * Converts all the information into a String format.
	 */
	
	public static String convertChangeToString(int twenty, int ten, int five, int one, int quarter, 
	   										int dime, int nickel, int penny, double itemPrice, double cashGiven) {
		//For DA the Cheese!
		String totalAmountBreakDown = "Amount: " + itemPrice + ", Tendered: "+cashGiven+ ", Result: ";
		
		if(twenty > 0) {
			if( twenty > 1) {
			totalAmountBreakDown += twenty + " twenty dollar bills, ";
			}
			else {
			totalAmountBreakDown += twenty + " twenty dollar bill, ";
			}
		}
		
		if(ten > 0) {
			if(ten > 1) {
			totalAmountBreakDown += ten + " ten dollar bills, ";
			}
			else {
			totalAmountBreakDown += ten + " ten dollar bill, ";
			}
		}
		
		if(five > 0) {
			if( five > 1) {
			totalAmountBreakDown += five + " five dollar bills, ";
			}
			else {
			totalAmountBreakDown += five + " five dollar bill, ";
			}
		}
		
		if(one > 0) {
			if(one > 1) {
			totalAmountBreakDown += one + " one dollar bills, ";
			}
			else {
			totalAmountBreakDown += one + " one dollar bill, ";
			}
		}
		
		if(quarter > 0) {
			if(quarter > 1) {
			totalAmountBreakDown += quarter + " quarters, ";
			}
			else {
			totalAmountBreakDown += quarter + " quarter, ";
			}
		}
		
		if(dime > 0) {
			if(dime > 1) {
				totalAmountBreakDown += dime + " dimes, ";
			}
			else {
			totalAmountBreakDown += dime + " dime, ";
			}
		}
		
		if(nickel > 0) {
			if(nickel > 1) {
				totalAmountBreakDown += nickel + " nickels, ";
			}
			else {
			totalAmountBreakDown += nickel + " nickel, ";
			}
		}
		
		if(penny > 0) {
			if(penny > 1) {
				totalAmountBreakDown += penny + " pennies. ";
			}
			else {
			totalAmountBreakDown += penny + " penny. ";
			}
		}
		
		
		
		
		return totalAmountBreakDown;
	}
	
	public static String lastStringCorrection() {
		
		
		return "ops i did it again";
	}

	//////////////////////////////////////////////DA END////////////OF/////////////////CLASS///////////////////////////////////////////////////////////////////////
}
