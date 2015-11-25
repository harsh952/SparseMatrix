//Harshkumar Desai
//CS435 - Project 1

public class ListEntry {
    
	private int value;

	private final int row;

	private final int col;

	public ListEntry(int value, int row, int col) {
	    this.value = value;
	    this.row = row;
	    this.col = col;
	}

	public int getRow(){
	  return row; 
	}
	public int getCol(){
	  return col;
	}
	public int getValue(){
	  return value;
	}
	public void setValue(int value){
	  this.value = value;
	}
}
