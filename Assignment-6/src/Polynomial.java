
/*
 * In this class the coefficients of polynomial equation is stored 
 * It requires the array of integer in constructor which contains the coefficients with index as their degree
 */

import java.util.ArrayList;
import java.util.Collections;


public final class Polynomial 
{
	private int poly[][];
	
	//parameterized constructor which eliminates 0 and store non zero coefficients 
	Polynomial(int input_poly[]) 
	{
		int index,count=0,row,column;
		row=column=0;
		
		//loop to count number of zeroes in the polynomial
		for(index=0;index<input_poly.length;index++)
		{
			
			if(input_poly[index]==0)
			{
				count++;
			}
			
		}
		
		int length=input_poly.length-count;
		
		//assigns size to poly which contains only non zero coefficients
		poly=new int[length][column+2];
		
		//assigns the value to the matrix with corresponding degrees
		for(index=0;index<input_poly.length;index++)
			if(input_poly[index]!=0 && row<length)
			{
				poly[row][column]=input_poly[index];
				poly[row++][column+1]=index;
			}
		
	}
	
	
	
	/*
	 * degree method to return the highest degree of the polynomial
	 * @return the maximum degree of the polynomial
	 */
	public int degree()
	{
		int row,column=1,length=poly.length;
		int max_degree=0;
		
		for(row=0;row<length;row++)
		{
			
			//checks for maximum degree
			if(max_degree < poly[row][column])
			{
				max_degree = poly[row][column];
			}
			
		}
		
		return max_degree;
	}
	
	 /*
	  * evaluate the polynomial with the given input value 
	  * @return the calculated result
	  */
	 public float evaluate(float value)
	 {
		 float result=0.0f;
		 int column=0,index;
		 
		 //evaluates the polynomial with the given input as value of variable
		 for(index=0;index<poly.length;index++)
		 {
			 result= result+(float)Math.pow(value, poly[index][column+1])*poly[index][column];
		 }
		 
		 return result;
	 }
	
	 /*
	  * add the two polynomial
	  * @param requires the two object which contains the polynomial 
	  * @return the integer array which contain the result of addition polynomial coefficients 
	  */
	static int[] addPoly(Polynomial p1, Polynomial p2)
	{
		
		ArrayList<Integer> coefficient= new ArrayList<Integer>();
		ArrayList<Integer> degree= new ArrayList<Integer>(); 
		int index,column=0; 
		
		//checks for same degree coefficients and them , store in arraylist coefficients
		for(index=0;index<p1.poly.length;index++)
		{
			for(int j=0;j<p2.poly.length; j++)
			{
				if(p1.poly[index][column+1]==p2.poly[j][column+1])
				{
					coefficient.add(p1.poly[index][column]+p2.poly[j][column]);
					degree.add(p1.poly[index][column+1]);
					break;
				}
			}
		}
		
		//checks for remaining elements in polynomial 1 which are not added in coefficients arraylist  
		for(index=0;index<p1.poly.length;index++)
		{
			if (!degree.contains(p1.poly[index][column+1]))
			{
				coefficient.add(p1.poly[index][column]);
				degree.add(p1.poly[index][column+1]);
			}
		}
		
		//checks for remaining elements in polynomial 2 which are not added in coefficients arraylist
		for(index=0;index<p2.poly.length;index++)
		{
			if (!degree.contains(p2.poly[index][column+1]))
			{
				coefficient.add(p2.poly[index][column]);
				degree.add(p2.poly[index][column+1]);
			}
		}
		
		//converting it back to the array in 1D
		int[] aPoly = new int[Collections.max(degree)+1];
		for(index =0;index<aPoly.length;index++)
		{
			if(degree.contains(index))
			{
				int pos = degree.indexOf(index);
				aPoly[index] = coefficient.get(pos);
			}
			else
			{
				aPoly[index] = 0;
			}
		}
		return aPoly;
	}
	
	/*
	 * multiply the two polynomial
	 * @param requires the two object of polynomial class which contains the polynomial coefficients
	 * @return the integer array which contains the coefficients if multiplied polynomial
	 */
	static int[] mulPoly(Polynomial p1, Polynomial p2)
	{
		ArrayList<Integer> coefficient= new ArrayList<Integer>();
		ArrayList<Integer> degree=  new ArrayList<Integer>();
		int sum,index,column=0;
		 
		//multiplies every term of first polynomial to each term of second polynomial
		for(index=0;index<p1.poly.length;index++)
		{
			 
			for(int j=0;j<p2.poly.length;j++)
			{
				coefficient.add(p1.poly[index][column]*p2.poly[j][column]);
				degree.add(p1.poly[index][column+1]+p2.poly[j][column+1]);
			}
		
		}
		 
		//two array list to simplify the calculated coefficients and degree
		ArrayList<Integer> finalcoff= new ArrayList<Integer>();
		ArrayList<Integer> finaldeg= new ArrayList<Integer>(); 
		
		//simplifies the arraylist by adding the term of same degree
		for(index=0;index<degree.size();index++)
		{
			sum=0;
			if(!finaldeg.contains(degree.get(index)))
			{
				for(int j=index;j<degree.size();j++)
				{
					if(degree.get(index)==degree.get(j))
					{
						sum= sum+coefficient.get(j);
					}
				}
				finalcoff.add(sum);
				finaldeg.add(degree.get(index));
			}
		}
	
		//converting it back to 1D array
		int[] mPoly = new int[Collections.max(finaldeg)+1];

		for(index =0;index<mPoly.length;index++)
		{
			
			if(finaldeg.contains(index))
			{
				int pos = finaldeg.indexOf(index);
				mPoly[index] = finalcoff.get(pos);
			}
			
			else
			{
				mPoly[index] = 0;
			}
			
		}
		
		return mPoly;
	}
	
}