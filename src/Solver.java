import java.util.Scanner;

public class Solver {

	static Cell[][]board = new Cell[9][9];
	static Possibilities[][] numbers = new Possibilities[9][9];

	static int[][]tester = {
		{0,0,0, 5,0,0, 0,0,0,},
		{0,0,0, 9,0,3, 0,2,0,},
		{0,5,0, 0,0,4, 6,0,0,},

		{0,9,6, 0,0,0, 2,1,0,},
		{1,7,0, 0,9,8, 0,0,0,},
		{0,4,0, 0,1,0, 3,0,9,},

		{0,1,0, 0,0,0, 7,0,4,},
		{0,2,0, 7,0,0, 0,5,3,},
		{0,8,4, 0,5,6, 0,0,0,}
	};

	public static void main(String[] args) {	

		initializePoints();
		drawBoard();
		while(finishedSolving() != true){
			determine();
		}

		//		String number = "";
		//		
		//		for(int y=0; y<9; y++){
		//			for(int x=0; x<9; x++){
		//				
		//				numbers[x][y] = new NumberList();
		//				numbers[x][y].add(1);
		//				NumberList.Node cursor = numbers[x][y].getHead();
		//				number = cursor.getNumber() + " ";
		//
		//			}
		//		}

		//		System.out.print(number);



	}


	public static void initializePoints(){

		for(int y=0; y<9; y++){
			for(int x=0; x<9; x++){

				board[x][y] = new Cell(false,0,0,x+1,y+1,0);	
				board[x][y].setGridX(findGridX(x));
				board[x][y].setGridY(findGridY(y));
				if(tester[x][y] != 0)
					board[x][y].setValue(tester[x][y]);
				else
					numbers[x][y] = new Possibilities();

			}
		}



		//		Scanner scan = new Scanner(System.in);
		//
		//		while(true){
		//
		//			System.out.println("please insert an x coordinate");
		//
		//			int xCord = scan.nextInt();
		//
		//			System.out.println("please insert an y coordinate");
		//
		//			int yCord = scan.nextInt();
		//
		//			System.out.println("please insert a number to insert");
		//
		//			int number = scan.nextInt();
		//
		//			if(xCord == 0 || yCord == 0 || number == 0){
		//
		//				break;
		//			}
		//
		//			board[xCord-1][yCord-1].setValue(number);
		//			board[xCord-1][yCord-1].setFinished(true);
		//			drawBoard();
		//
		//		}
	}

	public static void drawBoard(){

		int rowCount=0;
		for(int x=0; x<9; x++){

			String output = "";
			int columnCount = 0;
			for(int y=0; y<9; y++){

				columnCount++;
				if(columnCount==3||columnCount==6)
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
							sameCollumOrRow(n,x,y) == false &&
							sameGrid(n,board[x][y].getGridX(),board[x][y].getGridY()) == false){

						numbers[x][y] = new Possibilities();
						numbers[x][y].add(n);
					}
				}
			}
		}

	}


	public static void clearPossibilities(){

		for(int y=0; y<9; y++){
			for(int x=0; x<9; x++){

				numbers[x][y] = null;

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
	                    
	                    if (!board[x][y].getFinished())
	                    {
	                        Possibilities.Node curr = numbers[x][y].getHead();
	                        
	                        // go through all possibilities at position
	                        while (curr != null)
	                        {
	                            if(curr.getNumber() == n){
	                                count++;
	                                temp = x;
	                            }
	                            curr = curr.getNext();
	                        }
	                    }
	                }
	                if(count == 1){
	                    board[temp][y].setValue(n);
	                    board[temp][y].setFinished(true);
	                    drawBoard();
	                }
	            }
	        }
	    }
	}
	public static void onlyPossibleNumber(){
		//Has bug
		for(int y=0; y<9; y++){
			for(int x=0; x<9; x++){

				if(board[x][y].getFinished()==false && numbers[x][y].getHead()!=null){
					
					Possibilities.Node cursor = numbers[x][y].getHead();

					if(cursor!=null && cursor.getNext()==null){ 

						board[x][y].setFinished(true);
						board[x][y].setValue(cursor.getNumber());
						drawBoard();
					}
				}
			}
		}

	}





	public static void determine(){

		update();
		onlyPossibility();
		//onlyPossibleNumber(); 

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

