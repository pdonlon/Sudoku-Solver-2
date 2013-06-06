import java.util.Scanner;

public class Solver {

	static Possibilities[][]board = new Possibilities[9][9];
	static NumberList[][] numbers = new NumberList[9][9];

	public static void main(String[] args) {	

		initializePoints();
		while(finishedSolving() != true)
			determine();
	}


	public static void initializePoints(){

		for(int y=0; y<9; y++){
			for(int x=0; x<9; x++){

				board[x][y] = new Possibilities(false,0,0,x+1,y+1,0);	
				board[x][y].setGridX(findGridX(x));
				board[x][y].setGridY(findGridY(y));
				
				numbers[x][y] = new NumberList();

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
			board[xCord-1][yCord-1].setFinished(true);
			drawBoard();

		}
	}

	public static void drawBoard(){

		int rowCount=0;
		for(int x=0; x<9; x++){

			String output = "";
			int collumCount = 0;
			for(int y=0; y<9; y++){

				collumCount++;
				if(collumCount==3||collumCount==6)
					output = output+board[x][y].getValue()+" "+"| ";
				else
					output = output+board[x][y].getValue()+" ";

			}
			rowCount++;
			if(rowCount==3||rowCount==6){
				System.out.println(output);
				System.out.println("- - - - - - - - - - -");
			}
			else
				System.out.println(output);

		}
		System.out.println("");

	}

	public static int findGridX(int x){

		int gridX = x/3;

		return gridX;
	}

	public static int findGridY(int y){

		int gridY = y/3;

		return gridY;
	}



	public static boolean sameCollumOrRow(int num, int xCord, int yCord){

		boolean same = false;

		for(int x=0; x<9; x++){

			if( num == board[x][yCord].getValue()){
				same = true;
				break;
			}
		}

		if(same == false){
			for(int y=0; y<9; y++){

				if( num == board[xCord][y].getValue()){
					same = true;
					break;
				}
			}
		}

		return same;
	}


	public static boolean sameGrid(int number, int gridX, int gridY){

		boolean same = false;

		for(int y=gridY*3; y<((gridY*3)+3); y++){
			for(int x=gridX*3; x<((gridX*3)+3); x++){

				if(number == board[x][y].getValue())
					same = true;
			}
		}

		return same;
	}

	public static void placePossibilities(){

		for(int n=1; n<10; n++){
			for(int y=0; y<9; y++){
				for(int x=0; x<9; x++){

					if(board[x][y].getFinished() == false && 
							sameCollumOrRow(n,x,y) == false 
							&& sameGrid(n,board[x][y].getGridX(),board[x][y].getGridY()) == false)

						numbers[x][y].add(n);
					
				}
			}
		}

	}


	public static void clearPossibilities(){

		for(int y=0; y<9; y++){
			for(int x=0; x<9; x++){

				numbers[x][y].empty();

			}	
		}

	}

	public static void update(){

		clearPossibilities();
		placePossibilities();

	}

	public static void onlyPossibility(){

		for(int n=1; n<10; n++){ //number to place

			for(int g=0; g<3; g++){ //grid number

				for(int y=g*3; y<((g*3)+3); y++){

					int count =0;
					int temp = 0;

					for(int x=g*3; x<((g*3)+3); x++){

						if(board[x][y].getValue() == n){
							count++;
							temp = x;


						}
						if(count == 1){
							board[temp][y].setValue(n);
							board[temp][y].setFinished(true);
						}
					}
				}
			}
		}
	}

	public static void onlyPossibleNumber(){

		for(int y=0; y<9; y++){
			for(int x=0; x<9; x++){

					NumberList.Node cursor = numbers[x][y].getHead();

					if(cursor!=null && cursor.getNext()==null){

						board[x][y].setFinished(true);
						board[x][y].setValue(cursor.getNumber());

					}
				}
			}

		}

	



	public static void determine(){

		onlyPossibility();
		onlyPossibleNumber();
		drawBoard();
		update();
	
	}

	public static boolean finishedSolving(){

		boolean done = true;

		for(int y=0; y<9; y++){
			for(int x=0; x<9; x++){

				if(board[x][y].getFinished()==false){
					done = false;
					break;
				}
				if(done == false)
					break;
			}

		}
		return done;
	}




}

