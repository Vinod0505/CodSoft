package tasks;

import java.util.Scanner;

interface IBank{
	void deposit(int amount);
	void withDraw(int amount);
	void checkBalance();
}
//atm implements IBank and overrides the abstract methods
class AtmmachineImpl implements IBank{

	double balance;

	public AtmmachineImpl(double balance) {
		this.balance=balance;
	}

	@Override
	public void deposit(int amount) {
		balance=balance+amount;
		System.out.println("Deposited"+ amount+" Successfully");
	}
	@Override
	public void withDraw(int amount) {
		if(balance>0&&balance>amount) {
			balance=balance-amount;
			System.out.println("Withdrawn "+amount+"Successfully");
		}
		else
		{
			if(amount>balance || balance<=0)
				System.out.println("******Insufficient balance*******");
		}
	}

	@Override
	public void checkBalance() {
		System.out.println("Your Available balance : "+balance);
	}
}
public class User {
	//to access scanner class within methods
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//initializing initial balance through constructor
		AtmmachineImpl atm = new AtmmachineImpl(5000);
		System.out.println("****Welcome****");
		System.out.println("*****Insert Your Card******");
		System.out.println("Enter our pin :");
		int pin =sc.nextInt();
		checkPin(pin);
		System.out.println("1.Deposit\n2.Withdraw\n3.checkBalance\n4.Exit");
		int n=sc.nextInt();
		//conditions to perform
		if(n==1) {
			System.out.println("Please enter amount to deposit");
			int amount=sc.nextInt();
			atm.deposit(amount);
		}
		else if(n==2) {
			System.out.println("Please enter amount to withdraw");
			int amount=sc.nextInt();
			atm.withDraw(amount);
		}
		else if(n==3) {
			atm.checkBalance();
		}
		if(n==4) {
			System.out.println("Thank You!!");
		}
		System.out.println("Do you want check Your Balance?"+"y/n");
		String check=sc.next();
		if(check.equalsIgnoreCase("y"))
			atm.checkBalance();
		System.out.println("Remove Your Card!!");
	}
	private static void checkPin(int pin) {
		boolean rs = false;
		while(pin<=999||pin>=10000) {
			rs=false;
			System.out.println("Invalid pin");
			System.out.println("Remove Your Card!!");
			rs=true;
			System.out.println("****Welcome****");
			System.out.println("*****Insert Your Card******");
			System.out.println("Enter our pin :");
			pin =sc.nextInt();

		}

	}

}
