import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Plinko_16_Arrange {

	static String username;
	static int earnedToken, leftToken;
	private static int dropToken;
	private static int[] topLine = {1,2,3,4,5,6,7,8,9};
	private static String[][] plinkoBoard = new String[10][9];
	private static int[] tokenArray = {1,3,5,7,9,7,5,3,1};
	private static int[] prizeArray = {100,200,300,400,500,400,300,200,100};
	private static int tokenSerial;
	private static int tokenParallel;
	private static int ranNum;
	private static int tokenPoints;
	private static int totalPoints;

	static int timeToWait = 500;


	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to PLINKO!");
		System.out.print("Please enter your name: ");
		username = input.nextLine();
		System.out.println("You are " + username + ".");


		putXXX();

		System.out.println("\n\nTOKEN BOARD\n");
		printTopLine();
		printTable_WithoutDelay();
		printTokenLine();

		System.out.print("\nThis is a Plinko board for earning token."
				+ "\nFor now, you have 1 token."
				+ "\nYou need to play a token game to earn extra tokens for PLINKO game."
				+ "\nWhere would you like to drop your token?: ");
		dropToken = input.nextInt();
		System.out.println("\n" + username + " chose (" + dropToken + ").");
		tokenParallel = dropToken-1;

		putOOO();

		System.out.println("\n\nTOKEN BOARD\n");
		printTopLine();
		printTable_WithDelay();
		printTokenLine();

		System.out.println("\n" + username + " earned " + tokenArray[tokenParallel] + " tokens.");
		System.out.println("Now, let's start the game with " + tokenArray[tokenParallel] + " tokens.");

		earnedToken = tokenArray[tokenParallel];
		leftToken = earnedToken;

		putXXX();

		System.out.println("\n\n\nPLINKO BOARD\n");
		printTopLine();
		printTable_WithoutDelay();
		printPrizeLine();

		System.out.println("\nThis is PLINKO board for game. Choose a slot for points.");

		for (int gameCount = 1; gameCount <= earnedToken; gameCount++) {

			System.out.print("\n\n\nRound " + gameCount
					+ "\nWhere would you like to drop your token?: ");
			dropToken = input.nextInt();
			System.out.println(username + " chose (" + dropToken + ").");
			tokenParallel = dropToken-1;

			putXXX();
			putOOO();

			System.out.println("\nPLINKO " + gameCount + "\n");
			printTopLine();
			printTable_WithDelay();
			printPrizeLine();

			--leftToken;
			tokenPoints = prizeArray[tokenParallel-1];
			totalPoints += tokenPoints;
			System.out.println("\nThat token landed in slot " + tokenParallel + ".");
			System.out.println("That token gained " + tokenPoints + " points.");
			System.out.println("You have " + leftToken + " tokens left.");


		}

		System.out.println("\n\n\nTHE END"
				+ "\n" + username + " earned " + totalPoints + " points.");

		input.close();

	}


	private static void putOOO() {

		for (tokenSerial=0; tokenSerial<plinkoBoard.length; tokenSerial++) {

			if (tokenParallel>0 && tokenParallel<8) {

				int merong = (int)(Math.random() * 2);

				if (merong == 0) {
					ranNum = 1;
				} else if (merong == 1) {
					ranNum = -1;
				}

			} else if (tokenParallel==0) {
				ranNum = 1;
			} if (tokenParallel==8) {
				ranNum = -1;
			}

			tokenParallel += ranNum;
			plinkoBoard[tokenSerial][tokenParallel] = " O ";
		}

	}

	private static void putXXX() {

		for (int i=0; i<plinkoBoard.length; i++) {
			for (int j=0; j<plinkoBoard[i].length; j++) {
				plinkoBoard[i][j] = "XXX";
			}
		}

	}

	private static void printTopLine() {

		System.out.print("\t");
		for (int i=0; i<9; i++) {
			System.out.print("("+topLine[i]+")" + "\t");
		}
		System.out.println("");

	}

	private static void printTable_WithoutDelay() {

		for (int i=0; i<plinkoBoard.length; i++) {
			System.out.print("\t");
			for (int j=0; j<plinkoBoard[i].length; j++) {
				System.out.print(plinkoBoard[i][j] + "\t");				
			}
			System.out.println("");
		}

	}

	private static void printTable_WithDelay() {

		for (int i=0; i<plinkoBoard.length; i++) {
			System.out.print("\t");
			for (int j=0; j<plinkoBoard[i].length; j++) {
				System.out.print(plinkoBoard[i][j] + "\t");				
			}
			System.out.println("");

			try {
				for(int k=0; k<1; k++) {
					TimeUnit.MILLISECONDS.sleep(timeToWait);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

	}

	private static void printTokenLine() {

		System.out.print("\t");
		for (int i=0; i<9; i++) {
			System.out.print(" " + tokenArray[i] + "\t");
		}
		System.out.println("");

	}

	private static void printPrizeLine() {

		System.out.print("\t");
		for (int i=0; i<9; i++) {
			System.out.print(prizeArray[i] + "\t");
		}
		System.out.println("");

	}

}
