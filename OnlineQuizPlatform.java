import java.util.Scanner;
public class OnlineQuizPlatform {
	Scanner x = new Scanner(System.in);
	private double balance;
	//no need to define a constructor here as the default constructor will be defined automatically, and balance will be initialized to zero
	public void checkBalance(){
		System.out.println("Your Balance Is " + balance);
	}
	public void depositMoney(){
		System.out.println("Enter How Much Do You Want To Deposit:");
		double deposit = x.nextDouble();
		balance += deposit;
		System.out.println("You've Deposited " + deposit);
		checkBalance();
	}
	public void withdrawMoney(){
		System.out.println("Enter How Much Do You Want To Withdraw:");
		double withdraw = x.nextDouble();
		if(withdraw > balance){
			System.out.println("You Can't Withdraw This Amount, Your Balance Is Lower Than The Amount You Want To Withdraw");
			System.out.println("Do You Think We Distribute Money");
		}
		else{
			balance -= withdraw;
			System.out.println("You Have Withdrew " + withdraw);
		}
		checkBalance();
	}
	public void exitTheProgram(){
		System.out.println("Thank You For Choosing Our Bank");
		System.exit(0);
	}
	public static void main(String[]args){
		Scanner x = new Scanner(System.in);
		OnlineQuizPlatform account = new OnlineQuizPlatform();
		System.out.println("Hello, Please Choose Which Transaction You Want");
		do{
			System.out.println("a) Deposit" + "\n" + "b) Withdraw" + "\n" + "c) Check Balance" + "\n" + "d) Exit");
			String answer = x.nextLine();
			if(answer.equalsIgnoreCase("a"))
				account.depositMoney();
			else if(answer.equalsIgnoreCase("b"))
				account.withdrawMoney();
			else if(answer.equalsIgnoreCase("c"))
				account.checkBalance();
			else if(answer.equalsIgnoreCase("d"))
				account.exitTheProgram();
			else
				System.out.println("Wrong choice, please try again");
			System.out.println("Do You Want To Make Another Transaction? (Yes/No)");
			String choice = x.nextLine();
			if(choice.equalsIgnoreCase("no")){
				System.out.println("Thank You For Choosing Our Bank");
				break;
			}
		}while(true);
		x.close(); //not necessary
	}
}
