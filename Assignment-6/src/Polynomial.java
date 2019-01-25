import java.util.ArrayList;


public final class Polynomial 
{
	private int poly[][];
	
	//parameterized constructor which eliminates 0 and store non zero coefficients 
	Polynomial(int input_poly[]) 
	{
		int index,count=0,row,column;
		
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
		poly=new int[length][2];
		
		row=column=0;
		
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
	 */
	public int degree()
	{
		int row,column=1,length=poly.length;
		int max_degree=0;
		for(row=0;row<length;row++)
		{
			if(max_degree < poly[row][column])
			{
				max_degree = poly[row][column];
			}
		}
		return max_degree;
	}
	
	 /*
	  * evaluate the polynomial with the given input value 
	  */
	 public float evaluate(float value)
	 {
		 float result=0.0f;
		 
		 for(int i=0;i<poly.length;i++)
		 {
			 result= result+(float)Math.pow(value, poly[i][1])*poly[i][0];
		 }
		 
		 return result;
	 }
	
	 /*
	  * add the two polynomial
	  */
	static void addPoly(Polynomial p1, Polynomial p2)
	{
		ArrayList<Integer> coff= new ArrayList<Integer>();
		ArrayList<Integer> deg= new ArrayList<Integer>();
		   
		   
		   for( int i=0;i<p1.poly.length;i++)
		   {
			   for(int j=0;j<p2.poly.length; j++)
			   {
				   if(p1.poly[i][1]==p2.poly[j][1])
				   {
					   coff.add(p1.poly[i][0]+p2.poly[j][0]);
					   deg.add(p1.poly[i][1]);
					   break;
					   
				   }
			   }
		   }
		   for(int i=0;i<p1.poly.length;i++)
		   {
			   if (deg.contains(p1.poly[i][1])==false)
			   {
				   coff.add(p1.poly[i][0]);
				   deg.add(p1.poly[i][1]);
			   }
		   }
		
		   for(int i=0;i<p2.poly.length;i++)
		   {
			   if (deg.contains(p2.poly[i][1])==false)
			   {
				   coff.add(p2.poly[i][0]);
				   deg.add(p2.poly[i][1]);
			   }
		   }
		
	}
	
	/*
	 * multiply the two polynomial
	 */
	static void mulPoly(Polynomial p1, Polynomial p2)
	{
		 ArrayList<Integer> coff= new ArrayList<Integer>();
		 ArrayList<Integer> deg=  new ArrayList<Integer>();
		
		 for(int i=0;i<p1.poly.length;i++)
		 {
			 for(int j=0;j<p2.poly.length;j++)
			 {
				coff.add(p1.poly[i][0]*p2.poly[j][0]);
				deg.add(p1.poly[i][1]+p2.poly[j][1]);
			 }
		 }
		 
		 
		 ArrayList<Integer> finalcoff= new ArrayList<Integer>();
		 ArrayList<Integer> finaldeg= new ArrayList<Integer>(); 
		 int sum;
		 for(int i=0;i<deg.size();i++)
		 {
			 sum=coff.get(i);
			 if(!finaldeg.contains(deg.get(i)))
			 {
				 for(int j=i+1;j<deg.size();j++)
				 {
					 if(deg.get(i)==deg.get(j))
					 {
						 sum= sum+coff.get(j);
					 }
				 }
				 finalcoff.add(sum);
				 finaldeg.add(deg.get(i));
			 }
			 
		 }
		
	}
	
	public static void main(String args[])
	{
		Polynomial p1=new Polynomial(new int[]{1});
		Polynomial p2 = new Polynomial(new int[]{1,0,3,6});
		Polynomial.mulPoly(p1,p2);
	}
}