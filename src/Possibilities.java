
public class Possibilities {

	boolean finished;
	int gridNumber, row, collum, value;



	public Possibilities(boolean finished, int gridNumber, 
			int row, int collum, int value){

		finished = this.finished;
		gridNumber = this.gridNumber;
		row = this.row;
		collum = this.collum;
		value = this.value;

	}

	public void setFinished(boolean finished){

		this.finished = finished;

	}

	public boolean getFinished(){

		return finished;

	}

	public void setGridNumber(int gridNumber){

		this.gridNumber = gridNumber;

	}

	public int getGridNumber(){

		return gridNumber;
	}

	public void setRow(int row){

		this.row = row;
	}

	public int getRow(){

		return row;
	}

	public void setCollum(int collum){

		this.collum = collum;
	}
	
	public int getCollum(){
		
		return collum;
	}
	
	public void setValue(int value){
		
		this.value = value;
	}
	
	public int getValue(){
		
		return value;
	}
}

