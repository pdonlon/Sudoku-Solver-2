
public class Possibilities {

	boolean finished;
	int gridNumber, row, colum, value;



	public Possibilities(boolean finished, int gridNumber, 
			int row, int colum, int value){

		this.finished = finished; 
		this.gridNumber = gridNumber;
		this.row = row;
		this.colum = colum;
		this.value = value;

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

	public void setColum(int colum){

		this.colum = colum;
	}
	
	public int getcolum(){
		
		return colum;
	}
	
	public void setValue(int value){
		
		this.value = value;
	}
	
	public int getValue(){
		
		return value;
	}
}

