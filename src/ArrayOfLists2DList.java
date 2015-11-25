//Harshkumar Desai
//CS435 - Project 1

public class ArrayOfLists2DList implements List2D<SLLListEntry>{
	private SLLListEntry [] rowHeaders;

    public ArrayOfLists2DList(int rows) {
        rowHeaders = new SLLListEntry[rows];
    }
    
    @Override
    public boolean rowEmpty(int i) {
      if(rowHeaders[i-1]!=null)  return false;
    
      return true;
    }

    @Override
    public boolean colEmpty(int j) {
    	while (rowHeaders[j]!= null){
    		SLLListEntry curr = rowHeaders[j];
            curr = curr.getNext();
            while(curr!=null){
            	if(curr.getCol()!=j)
            		curr=curr.getNext();
            	else
            		return false;
            }
    	}
    	return true;
     }
     
    @Override
    public SLLListEntry firstRowEntry(int i) {
      return rowHeaders[i-1];
    }

    @Override
    public SLLListEntry firstColEntry(int j) {
      while (rowHeaders[j]!=null){
      		SLLListEntry curr = firstRowEntry(j);
              curr = curr.getNext();
              while(curr!=null){
              	if(curr.getCol()!=j)
              		curr=curr.getNext();
              	else
              		return curr;
              }
      }
      return null;
    }
    
    @Override
    public SLLListEntry nextRowEntry(SLLListEntry entry) {
      if(entry.getNext()!=null){
    	  return entry.getNext();    
      }
      else
    	  return null;
    }

    @Override
    public SLLListEntry nextColEntry(SLLListEntry entry) {
    	int row= entry.getRow();
    	while(row<rowHeaders.length){
    		SLLListEntry curr = firstRowEntry(row);
    		while(curr!=null &&curr.getCol()<entry.getCol()){
    			curr=curr.getNext();
    		}
    		if(curr!=null && curr.getCol()==entry.getCol())
    			return curr;
    		row++;
    	}
        return null;        
    }

    @Override
    public boolean isLastEntryInRow(SLLListEntry entry) {
         if(entry.getNext()!=null) return false;
         return true;
    }

    @Override
    public boolean isLastEntryInCol(SLLListEntry entry) {
    	int row= entry.getRow();
    	while(row<rowHeaders.length){
    		SLLListEntry curr = firstRowEntry(row);
    		while(curr!=null){
    			if(curr.getCol()!=entry.getCol())
    				curr=curr.getNext();
    			else
    				return false;
    		}
    		row++;
    	}
        return true;
    }

    @Override
    public void insertValueAt(int c, int i, int j) {
    	SLLListEntry next=firstRowEntry(i);
    	SLLListEntry curr=null;
    	if(next==null){
    		rowHeaders[i-1]=new SLLListEntry(c,i,j,null);
    		return;
    	}
    	int temp=0;
    	while(next.getNext()!=null){
    		if(j<next.getCol() && temp==0){
    			rowHeaders[i-1]=new SLLListEntry(c,i,j,next);
    			return;
    		}
    		else if(j<next.getCol()){
    			curr = rowHeaders[i-1];
    			while(curr.getNext()!=next){
    				next=next.getNext();
    			}
    		}
    		else if(j==next.getCol()){
    			next.setValue(c);
    			return;
    		}
    		next=next.getNext();
    	}
    next.setNext(new SLLListEntry(c,i,j,null));
    }
}
