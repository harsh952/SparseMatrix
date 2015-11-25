//Harshkumar Desai
//CS435 - Project 1

import java.util.*;

public class SparseMatrixTestRev {

	public static void main(String[] args){
    	SparseMatrix MatrixA = new SparseMatrix("3r1c1, 5r1c4, 2r2c2, -7r2c3, 5r3c1, -3r3c2, 6r4c2, -5r4c4");
      SparseMatrix MatrixB = new SparseMatrix("1r1c1, 1r1c5, 1r2c2, 1r2c6, 1r3c3, 1r4c1, 1r4c4");
        
      String matrixC = generateMatrixC();
        SparseMatrix MatrixC = new SparseMatrix(matrixC);
        
 	   String matrixD = generateMatrixD();
        SparseMatrix MatrixD = new SparseMatrix(matrixD);
        
 	   String matrixE = generateMatrixE();
        SparseMatrix MatrixE = new SparseMatrix(matrixE);

 	   String matrixF = generateMatrixF();
        SparseMatrix MatrixF = new SparseMatrix(matrixF);
           
        System.out.println("Printing Non-Zero Matrix A: ");
        MatrixA.printNonZero();
        System.out.println("Printing Non-Zero Matrix B: ");
        MatrixB.printNonZero();
        System.out.println("Printing Non-Zero Matrix C: ");
        MatrixC.printNonZero();
        System.out.println("Printing Non Zero Matrix D: ");
        MatrixD.printNonZero();
        System.out.println("Printing Non Zero Matrix E: ");
        MatrixE.printNonZero();
        System.out.println("Printing Non Zero Matrix F: ");
        MatrixF.printNonZero();
 	   
        System.out.println("Printing Matrix A: ");
        MatrixA.print();
        System.out.println("Printing Matrix B: ");
        MatrixB.print();
        System.out.println("Printing Matrix C: ");
        MatrixC.print();
        System.out.println("Printing Matrix D: ");
        MatrixD.print();
        System.out.println("Printing Matrix E: ");
        MatrixE.print();
        System.out.println("Printing Matrix F: ");
        MatrixF.print();
        
 	   System.out.println("Printing Matrix A scalar multiplied by 5 \n ");
 	   MatrixA.scalarMultiply(5).print();
 	   System.out.println("Printing Matrix B scalar multiplied by 5 \n ");
 	   MatrixB.scalarMultiply(5).print();
 	   System.out.println("Printing Matrix C scalar multiplied by 5 \n ");
 	   MatrixC.scalarMultiply(5).print();
 	   System.out.println("Printing Matrix D scalar multiplied by 5 \n ");
 	   MatrixD.scalarMultiply(5).print();
 	   System.out.println("Printing Matrix E scalar multiplied by 5 \n ");
 	   MatrixE.scalarMultiply(5).print();
 	   System.out.println("Printing Matrix F scalar multiplied by 5 \n ");
 	   MatrixF.scalarMultiply(5).print();

 	   System.out.println("A equals A = " + MatrixA.equals(MatrixA));
 	   System.out.println("B equals B = " + MatrixB.equals(MatrixB));
 	   System.out.println("C equals C = " + MatrixC.equals(MatrixC));
 	   System.out.println("D equals D = " + MatrixD.equals(MatrixD));
 	   System.out.println("E equals E = " + MatrixE.equals(MatrixE));
 	   System.out.println("F equals F = " + MatrixF.equals(MatrixF));
 	   
 	   System.out.println("A equals C = " + MatrixA.equals(MatrixC));
 	   System.out.println("A equals D = " + MatrixA.equals(MatrixD));
 	   System.out.println("A equals E = " + MatrixA.equals(MatrixE));
 	   System.out.println("A equals F = " + MatrixA.equals(MatrixF));
 	  
 	   System.out.println("B equals C = " + MatrixB.equals(MatrixC));
 	   System.out.println("B equals D = " + MatrixB.equals(MatrixD));
 	   System.out.println("B equals E = " + MatrixB.equals(MatrixE));
 	   System.out.println("B equals F = " + MatrixB.equals(MatrixF));
 	   
 	   System.out.println("C equals D = " + MatrixC.equals(MatrixD));
 	   System.out.println("C equals E = " + MatrixC.equals(MatrixE));
 	   System.out.println("C equals F = " + MatrixC.equals(MatrixF));
 	   
 	   System.out.println("D equals E = " + MatrixD.equals(MatrixE));
	   System.out.println("D equals F = " + MatrixD.equals(MatrixF));
	   
	   System.out.println("E equals F = " + MatrixC.equals(MatrixE));
	  
 
 	   System.out.println("Adding Matrix A with Matrix A");
 	   MatrixA.add(MatrixA).print();
 	   System.out.println("Adding Matrix B with Matrix B");
 	   MatrixB.add(MatrixB).print();
 	   System.out.println("Adding Matrix C with Matrix C");
 	   MatrixC.add(MatrixC).print();
 	   System.out.println("Adding Matrix D with Matrix D");
 	   MatrixD.add(MatrixD).print();
 	   System.out.println("Adding Matrix E with Matrix E");
 	   MatrixE.add(MatrixE).print();
 	   System.out.println("Adding Matrix F with Matrix F");
 	   MatrixF.add(MatrixF).print();

 	   
 	   System.out.println("Subtracting Matrix A with Matrix A");
 	   MatrixA.subtract(MatrixA).print();
 	   System.out.println("Subtracting Matrix B with Matrix B");
 	   MatrixB.subtract(MatrixB).print();
 	   System.out.println("Subtracting Matrix C with Matrix C");
 	   MatrixC.subtract(MatrixC).print();
 	   System.out.println("Subtracting Matrix D with Matrix D");
 	   MatrixD.subtract(MatrixD).print();
 	   System.out.println("Subtracting Matrix E with Matrix E");
 	   MatrixE.subtract(MatrixE).print();
 	   System.out.println("Subtracting Matrix F with Matrix F");
 	   MatrixF.subtract(MatrixF).print();
 	   
 	   System.out.println("Subtracting Matrix A - A*5");
 	   MatrixA.subtract(MatrixA.scalarMultiply(5)).print();
 	   System.out.println("Subtracting Matrix B - B*5");
 	   MatrixB.subtract(MatrixB.scalarMultiply(5)).print();
 	   System.out.println("Subtracting Matrix C - C*5");
 	   MatrixC.subtract(MatrixC.scalarMultiply(5)).print();
 	   System.out.println("Subtracting Matrix D - D*5");
 	   MatrixD.subtract(MatrixD.scalarMultiply(5)).print();
 	   System.out.println("Subtracting Matrix E - E*5");
 	   MatrixE.subtract(MatrixE.scalarMultiply(5)).print();
 	   System.out.println("Subtracting Matrix F - F*5");
 	   MatrixF.subtract(MatrixF.scalarMultiply(5)).print();

	   System.out. println("The program will now print Matrix G and its manipulation.Please wait few seconds");
       	   
	   String matrixG = generateMatrixG();
      SparseMatrix MatrixG = new SparseMatrix(matrixG);
      System.out.println("Printing Non Zero Matrix G: ");
      MatrixG.printNonZero();
      System.out.println("Printing Matrix G: ");
      MatrixG.print();
      System.out.println("Printing Matrix G scalar multiplied by 5 \n ");
	   MatrixG.scalarMultiply(5).print();
	   System.out.println("G equals A = " + MatrixG.equals(MatrixA));
	   System.out.println("G equals B = " + MatrixG.equals(MatrixB));
	   System.out.println("G equals C = " + MatrixG.equals(MatrixC));
	   System.out.println("G equals D = " + MatrixG.equals(MatrixD));
	   System.out.println("G equals E = " + MatrixG.equals(MatrixE));
	   System.out.println("G equals F = " + MatrixG.equals(MatrixF));
	   System.out.println("Adding Matrix G with Matrix G");
	   MatrixG.add(MatrixG).print();
	   System.out.println("subtracting Matrix G with Matrix G");
	   MatrixG.subtract(MatrixG).print();
	   System.out.println("Subtracting Matrix G - G*5");
	   MatrixG.subtract(MatrixG.scalarMultiply(5)).print();
     }

    public static String generateMatrixC(){
    		
    		String m="";
    		
    		for(int i=1; i<6; i++)
    			for(int j=1; j<7; j++)
    				if((i+j)%2==0 && i*j!=0)
    					m +=((i*j)+"r"+i+"c"+j+", ");
    		
    			
    		return m;
    	}
    	
    	public static String generateMatrixD(){
    		
    		String m="";
    		
    		for(int i=1; i<7; i++)
    			for(int j=1; j<6; j++)
    				if((i*j)%4==0 && (i+j)!=0)
    					m+=(i+j)+"r"+i+"c"+j+", ";
    		
    		
    			return m;
    	}
    	
    	public static String generateMatrixE(){
    		
    		String m="";
    		
    		for(int i=1; i<200; i++)
    			for(int j=1; j<200; j++)
    				if(i%10==0)
    					m+=(i+2*j)+"r"+i+"c"+j+", ";
    		
    			
    		return m;
    	}
    	
    	public static String generateMatrixF(){
    		
    		String m="";
    		
    		for(int i=1; i<200; i++)
    			for(int j=1; j<2; j++)
    				if(i%5==0)
    					m+=(i*5)+"r"+i+"c"+j+", ";
    		
    			
    		return m;
    	}
    	
   	public static String generateMatrixG(){
   		
   		StringBuilder s = new StringBuilder();
   		Random r = new Random(System.currentTimeMillis());
   		
   		for(int i=1; i<=30000; i++)
   			for(int j=1; j<=30000; j++)
   				if(r.nextInt()%1000==0)
   					s.append(((i+j)+"r"+i+"c"+j+", "));
   				
   		
   		return s.toString();
   	}

}


