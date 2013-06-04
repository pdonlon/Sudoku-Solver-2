import java.util.Scanner;

public class Solver {

	static Possibilities[][]board = new Possibilities[9][9];
	static NumberList[][] numbers = new NumberList[9][9];

	public static void main(String[] args) {	

		initializePoints();
	}


	public static void initializePoints(){

		for(int y=0; y<9; y++){
			for(int x=0; x<9; x++){

				board[x][y] = new Possibilities(false,0,x+1,y+1,0);	
				board[x][y].setGridNumber(findGridNumber(x,y));
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

	public static int findGridNumber(int x, int y){

		int gridNumber = 0;

		if(x<3 && y<3) //top left
			gridNumber =1;
		if(x>2 && x<6 && y<3) //top mid
			gridNumber =2;
		if(x>5 && y<3)
			gridNumber =3; //top right

		if(x<3 && y>2 && y<6) //mid left
			gridNumber =4;
		if(x>2 && x<6 && y>2 && y<6) //mid mid
			gridNumber =5;
		if(x>5 && y>2 && y<6) //mid right
			gridNumber =6;

		if(x<3 && y>5) //bottom left
			gridNumber =7;
		if(x>2 && x<6 && y>5) //bottom mid
			gridNumber =8;
		if(x>5 && y>5) //bottom right
			gridNumber =9;

		return gridNumber;
	}
	
	public boolean sameCollumOrRow(int num, int xCord, int yCord){

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
	
	//TODO
	public boolean sameGrid(){
		
		boolean same = false;
		
		return same;
		
	}

	public void placePossibilities(){
		
		for(int n=1; n<10; n++){
			for(int y=0; y<9; y++){
				for(int x=0; x<9; x++){

					if(board[x][y].getFinished()!= true && 
						sameCollumOrRow(n,x,y)!=true )
						//&& sameGrid() == false
						
						numbers[x][y].add(n);

				

				}
			}
		}

	}
	
	
	public void clearPossibilities(){
		
		for(int y=0; y<9; y++){
			for(int x=0; x<9; x++){
				
				numbers[x][y].empty();
				
			}	
		}
		
	}
	
	public void upDate(){
		
		placePossibilities();
		clearPossibilities();
		
	}

}

