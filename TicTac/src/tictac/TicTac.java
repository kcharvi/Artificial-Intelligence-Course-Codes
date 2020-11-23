package tictac;
import java.util.*; 
/**
 *
 * @author Charvi
 */
public class TicTac { 
	
	static String[] board; 
	static String turn; 
        static int[] magicSquare = new int[]{2, 7, 6, 9, 5, 1, 4, 3, 8};
	static String checkWinner() 
	{ 
		for (int a = 0; a < 8; a++) { 
			String line = null; 
                        int sum= 0;
			switch (a) { 
			case 0:{ 
				line = board[0] + board[1] + board[2]; 
                                sum= magicSquare[0]+magicSquare[1]+magicSquare[2];
				break; }
			case 1:{ 
				line = board[3] + board[4] + board[5]; 
                                sum= magicSquare[3]+magicSquare[4]+magicSquare[5];
				break; }
			case 2: {
				line = board[6] + board[7] + board[8]; 
                                sum= magicSquare[6]+magicSquare[7]+magicSquare[8];
				break; }
			case 3: {
				line = board[0] + board[3] + board[6]; 
                                sum= magicSquare[0]+magicSquare[3]+magicSquare[6];
				break; }
			case 4:{ 
				line = board[1] + board[4] + board[7]; 
                                sum= magicSquare[1]+magicSquare[4]+magicSquare[7];
				break; }
			case 5:{ 
				line = board[2] + board[5] + board[8]; 
                                sum= magicSquare[2]+magicSquare[5]+magicSquare[8];
				break; }
			case 6: {
				line = board[0] + board[4] + board[8]; 
                                sum= magicSquare[0]+magicSquare[4]+magicSquare[8];
				break; }
			case 7: {
				line = board[2] + board[4] + board[6]; 
                                sum= magicSquare[2]+magicSquare[4]+magicSquare[6];
				break; }
			}
                        
			if (line.equals("XXX")&&sum==15) { 
                                System.out.println("Next possible move ");
				return "X"; 
			} 
			else if (line.equals("OOO")&&sum==15) { 
                            return "O";
			} 
		} 
		
		for (int a = 0; a < 9; a++) { 
			if (Arrays.asList(board).contains( String.valueOf(a + 1))) { 
				break; 
			} 
			else if (a == 8) { 
				return "draw"; 
			} 
		} 
		System.out.println(turn + "'s turn; enter a slot number to place "+ turn + " in:"); 
		return null; 
	} 
	static void printBoard() 
	{ 

		System.out.println("  " + board[0] + "  "+ board[1] + "  " + board[2]+ "  "); 
		System.out.println("  "); 
                System.out.println("  " + board[3] + "  "+ board[4] + "  " + board[5] + "  "); 
		System.out.println("  "); 
		System.out.println("  " + board[6] + "  "+ board[7] + "  " + board[8] + "  "); 

	} 

	public static void main(String[] args) 
	{ 
		Scanner in = new Scanner(System.in); 
		board = new String[9]; 
		turn = "X"; 
		String winner = null; 

		for (int a = 0; a < 9; a++) { 
			board[a] = String.valueOf(a + 1); 
		} 
		printBoard(); 
		System.out.println("X will play first. Enter a slot number to place X in:"); 
		while (winner == null) { 
			int numInput; 
			try { 
				numInput = in.nextInt(); 
				if (!(numInput > 0 && numInput <= 9)) { 
					System.out.println("Invalid input re-enter slot number:"); 
					continue; 
				} 
			} 
			catch (InputMismatchException e) { 
				System.out.println( "Invalid input re-enter slot number:"); 
				continue;
			}
			if (board[numInput - 1].equals( 
					String.valueOf(numInput))) { 
				board[numInput - 1] = turn; 

				if (turn.equals("X")) { 
					turn = "O"; 
				} 
				else { 
					turn = "X"; 
				} 

				printBoard(); 
				winner = checkWinner(); 
			} 
			else { 
				System.out.println("Slot already taken re-enter slot number:"); 
			} 
		} 
		if (winner.equals("draw")) { 
			System.out.println("It's a draw! Thanks for playing."); 
		}
		else { 
			System.out.println(winner + " has won! Thanks for playing."); 
		} 
	} 
}
