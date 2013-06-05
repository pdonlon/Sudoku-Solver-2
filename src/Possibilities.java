
public class Possibilities {

	boolean finished;
	int gridX, gridY, row, colum, value;



	public Possibilities(boolean finished, int gridX, int gridY, 
			int row, int colum, int value){

		this.finished = finished; 
		this.gridX = gridX;
		this.gridY = gridY;
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

	public void setGridX(int gridX){

		this.gridX = gridX;

	}
	
	public int getGridX(){
		
		return gridX;
	}
	

	public void setGridY(int gridY){

		this.gridY = gridY;

	}
	
	public int getGridY(){
		
		return gridY;
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

