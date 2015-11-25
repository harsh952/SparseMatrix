//Harshkumar Desai
//CS435 - Project 1

public interface List2D<T extends ListEntry> {
	public boolean rowEmpty(int i);
    public boolean colEmpty(int j);
    
    public T firstRowEntry(int i);
    public T firstColEntry(int j);
    
    public T nextRowEntry(T entry);
    public T nextColEntry(T entry);
    
    public boolean isLastEntryInRow(T entry);
    public boolean isLastEntryInCol(T entry);
    
   //@Override 
    public void insertValueAt(int c, int i, int j);
}
