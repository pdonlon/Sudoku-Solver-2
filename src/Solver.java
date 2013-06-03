import java.util.Scanner;

public class Solver {

	Possibilities[][]board = new Possibilities[9][9];

	public static void main(String[] args) {	


	}


	public void initializePoints(){

		for(int y=0; y<9; y++){
			for(int x=0; x<9; x++){
				board[x][y].setCollum(y+1);
				board[x][y].setRow(x+1);
			}
		}
		
		Scanner scan = new Scanner(System.in);

		while(true){

			System.out.println("please insert an x coordinate");

			int xCord = scan.nextInt();

			System.out.println("please insert an y coordinate");

			int yCord = scan.nextInt();

			System.out.println("please insert a number to insert");

			int number = scan.nextInt();

			if(xCord == 0 || yCord == 0 || number == 0){

				break;
			}

			board[xCord-1][yCord-1].setValue(number);

			//drawBoard();

		}

	}
}
