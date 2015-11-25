//Harshkumar Desai
//CS435 - Project 1

public class SparseMatrix {
private final List2D list;
    
    private final int m;
    private final int n;
    
    public SparseMatrix(int m, int n) {
        this.m = m;
        this.n = n;
        this.list = new ArrayOfLists2DList(m);
    }
    
    public SparseMatrix(String str) {
      String[] inputSplitted = str.split(", ");
       int[] row = new int[inputSplitted.length], col = new int[inputSplitted.length], val = new int[inputSplitted.length];
         for(int i=0; i<inputSplitted.length;i++) {
        	 String[] splitRC = inputSplitted[i].split("r|c");  
	         val[i] = Integer.parseInt(splitRC[0]);
	         col[i] = Integer.parseInt(splitRC[2]);
	         row[i] = Integer.parseInt(splitRC[1]);
         }	
         this.m = row[row.length-1];
         int tempN = 0;
         for(int i = 0; i<col.length;i++){
        	if(col[i]>tempN) {
        		tempN=col[i]; 
        	}
         }
         this.n=tempN;
         list = new ArrayOfLists2DList(this.m);
         for(int j = 0; j<inputSplitted.length; j++){
         list.insertValueAt(val[j],row[j],col[j]);
    }
    }

	//print matrix
    public void print() {
		for(int i=1; i<=m; i++){
			int pos=1;
	    	ListEntry printVal = this.list.firstRowEntry(i);
	    	if(m > 6 && i == 4)
	    	{
	    		System.out.println("\t...");
	    		i = m-3;
	    		continue;
	    	}
	    	
	    	if(this.list.rowEmpty(i))
	    	{
	    		while(pos <= n)
	    		{
	    			if(n > 6 && pos == 4)
	    			{
	    				System.out.print(" ... ");
	    				pos=n-2;
	    				continue;
	    			}
	    			System.out.print(" 0");
	    			pos++;
	    		}
	    	}
	    	else
	    	{
	    		while(printVal != null)
	    		{
	    			if(n > 6 && pos == 4)
	    			{
	    				System.out.print(" ... ");
	    				pos = n-2;
	    				continue;
	    			}
	    			if(this.list.isLastEntryInRow(printVal))
	    			{
	    				while(pos < printVal.getCol())
	    				{
	    					pos++;
	    					System.out.print(" 0");
	    				}
	    				System.out.print(" " + printVal.getValue());
	    				pos++;
	    				while(pos <= n)
	    				{
	    					System.out.print(" 0");
	    					pos++;
	    				}
	    				printVal = this.list.nextRowEntry(printVal);
	    			}
	    			else if(pos < printVal.getCol())
	    			{
	    				while(pos < printVal.getCol() && pos != 3)
	    				{
	    					System.out.print(" 0");
	    					pos++;
	    				}
	    				if(pos == 3)
	    				{
	    					System.out.print(" 0");
	    					pos++;
	    					continue;
	    				}
	    				System.out.print(" " + printVal.getValue());
	    				pos++;
	    				printVal = this.list.nextRowEntry(printVal);
	    			}
	    			else if(pos > printVal.getCol())
	    			{
	    				printVal = this.list.nextRowEntry(printVal);
	    			}
	    			else
	    			{
	    				System.out.print(" " + 
	    			printVal.getValue());
	    				pos++;
	    				printVal = this.list.nextRowEntry(printVal);
	    			}
	    		}
	    	}
	       System.out.println("");
		}
    }

    public boolean equals(SparseMatrix m) {
      int inputRow = m.m;
      int inputCol = m.n;
      if(this.m!=inputRow || n!=inputCol){
      return false;
      }
      for(int i = 1; i<inputRow; i++){
         ListEntry curr = this.list.firstRowEntry(i);
         ListEntry mCurr = m.list.firstRowEntry(i);
         while(mCurr!=null){
            if(mCurr.getRow()==curr.getRow() && 
               mCurr.getCol()==curr.getCol() &&
               mCurr.getValue()==curr.getValue()){
    		      curr = list.nextRowEntry(curr);
    				mCurr = m.list.nextRowEntry(mCurr);
    	      }
            else
    		      return false;
         } 
      }
      return true;
   }
                  
    public SparseMatrix scalarMultiply(int c) {
     SparseMatrix multResult = new SparseMatrix (m,n);
    	for(int i=1;i<=m;i++){
    		ListEntry curr = this.list.firstRowEntry(i);
    		while(curr!=null){
    			multResult.list.insertValueAt(curr.getValue() * c,curr.getRow(),curr.getCol());
    			curr = list.nextRowEntry(curr);
    		}
    	}
        return multResult;
    }
    public SparseMatrix add(SparseMatrix m) {
    	if(m==null || this==null){
    		System.out.println("not valid matrices");
    		return null;
    	}
    	if(this.m != m.m || n != m.n)
    	{
    		System.out.println("Cannot add these 2 matrices");
    		return null;
    	}
        SparseMatrix result = new SparseMatrix(m.m,n);
        for(int i = 1; i <= this.m; ++i){
	        if(!m.list.rowEmpty(i)){
	        	ListEntry currElementM = m.list.firstRowEntry(i);
	       
	        	while(currElementM != null){
	        		SLLListEntry currElementThis = (SLLListEntry) this.list.firstRowEntry(i);
	        		while(currElementThis.getCol()<currElementM.getCol()){
    		        	//System.out.println(currElementThis.getValue());
            			currElementThis = currElementThis.getNext();
            		}
	        		if(currElementThis.getCol()==currElementM.getCol()){
	        			
	    		        	//System.out.println(currElementThis.getValue());
	    		     
	    		        	result.list.insertValueAt(currElementThis.getValue()+currElementM.getValue(), i, currElementThis.getCol());
	        		}
	        	
	        			currElementM = list.nextRowEntry(currElementM);
	        	}
	        }
	    }
        return result;
    }
    
    public SparseMatrix subtract(SparseMatrix m) {
    	if(m==null || this==null){
    		System.out.println("not valid matrices");
    		return null;
    	}
    	if(this.m != m.m || n != m.n)
    	{
    		System.out.println("Cannot subtract these 2 matrices");
    		return null;
    	}
    	
        SparseMatrix result = new SparseMatrix(m.m,n);
        for(int i = 1; i <= this.m; ++i){
	        if(!m.list.rowEmpty(i)){
	        	ListEntry currElementM = m.list.firstRowEntry(i);

	        	while(currElementM != null){
	        		SLLListEntry currElementThis = (SLLListEntry) this.list.firstRowEntry(i);
	        		while(currElementThis.getCol()<currElementM.getCol()){
    		        	//System.out.println(currElementThis.getValue());
            			currElementThis = currElementThis.getNext();
            		}
	        		if(currElementThis.getCol()==currElementM.getCol()){
	        			
	    		        	//System.out.println(currElementThis.getValue());
	    		     
	    		        	result.list.insertValueAt(currElementThis.getValue()-currElementM.getValue(), i, currElementThis.getCol());
	        		}

	        			currElementM = list.nextRowEntry(currElementM);
	        	}
	        }
	    }
        return result;
    }
    
/*
    public SparseMatrix multiply(SparseMatrix m) {

    }
    
    public SparseMatrix transpose() {
        
    }
	*/
    public void printNonZero() {
        System.out.println("Printing Non-Zero Matrix:");
            	for(int i=1; i<=m; i++){
    	        	ListEntry printVal = this.list.firstRowEntry(i);
                    while(printVal!=null){
                    	System.out.print(printVal.getValue()+"\t");
    		        	   //System.out.print(printVal.getValue()+" ");
                           printVal = this.list.nextRowEntry(printVal);
                   }
                   System.out.println("");
                }        
        }
}
