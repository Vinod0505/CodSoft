package tasks;

import java.util.Random;
import java.util.Scanner;

class NumberGame {
	//scanner class for user enter
	static Scanner scan = new Scanner(System.in);
	//variables
	static	String playerName;
	static  int countWon=0;
	static int countLost=0;
	static int rounds=0;

	static void play() {
		rounds++;
		System.out.println("Round: "+rounds);
		int attempts=3;
		boolean win=false;
		//while loop to limit number of attempts
		while(attempts>0&&win==false) {
			System.out.println(playerName+" enter your number : ");
			int number=scan.nextInt();
			scan.nextLine();
			//Object of Random class to generate random numbers UPto 100
			Random random=new Random();
			int range=100;
			int randomNumber=random.nextInt(range)+1;
			System.out.println("Randomly Generated Number : "+randomNumber);

			//conditions
			if(number<0&&number>range) {
				System.out.println("Please enter number in range 1 to 100");
			}
			else if(number==randomNumber) {
				System.out.println("your Guess is correct\n "+playerName+" You won");
				win =true;
				countWon++;
				System.out.println("You won the game : "+countWon);
			}
			if(win==false) {
				countLost++;
				attempts--;
				System.out.println("You have left with "+attempts+" attempts !");
			}
			if(number>randomNumber) {
				System.out.println("Guess is too high");
			}
			if(number<randomNumber) {
				System.out.println("Your guess is too low");
			}
			System.out.println("----------------------------------------");

		}
		System.out.println(playerName+" Do you want to play again? "+" y/n ");
		String again=scan.nextLine();
		if(again.equalsIgnoreCase("y"))
			play();
	}
	public static void main(String[] args) {
		System.out.println("***** Game Starts! *****");
		System.out.println("Enter player name : ");
		playerName=scan.nextLine();
		System.out.println("You have 3 chances to attempt ");
		play();
		System.out.println(playerName+" You won the game "+countWon+" in "+rounds+"Rounds ");
		System.out.println("******* Game Ended! *******");
	}
}
