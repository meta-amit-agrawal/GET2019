import java.text.DecimalFormat;

public class Area 
{
	DecimalFormat decimalFormat=new DecimalFormat(".##"); // it will return the floating point values up to 2 decimal points 
	
	double area_result=0.0;
	
	/*
	 * calculateAreaOfTriangle method to calculate the area of the triangle
	 * @param base which hold the length of base of triangle, assuming base>0
	 * @param height which holds the height of the triangle, assuming height>0
	 * @return the area of the triangle as a string value and up to 2 decimal points
	 */
	public String calculateAreaTriangle(double base , double height) throws ArithmeticException
	{
		
		try
		{
			area_result=(0.5)*base*height;
			return decimalFormat.format(area_result);
		}
		
		catch(ArithmeticException e)
		{
			throw e;
		}
		
	}
	
	/*
	 * calculateAreaOfCircle method to calculate the area of the circle
	 * @param radius which hold the radius of circle, assuming radius>0
	 * @return the area of the circle as a string value and up to 2 decimal points
	 */
	public String calculateAreaOfCircle(double radius) throws ArithmeticException
	{
		
		try
		{
			area_result=Math.PI * Math.pow(radius, 2);
			return decimalFormat.format(area_result);
		}
		
		catch(ArithmeticException e)
		{
			throw e;
		}
		
	}
	
	/*
	 * calculateAreaOfRectangle method to calculate the area of the rectangle
	 * @param length which hold the length or height of rectangle, assuming length>0
	 * @param breadth which holds the breadth of the rectangle, assuming breadth>0
	 * @return the area of the rectangle as a string value and up to 2 decimal points
	 */
	public String calculateAreaOfRectangle(double length , double breadth) throws ArithmeticException
	{
		
		try
		{
			area_result=length*breadth;
			return decimalFormat.format(area_result);
		}
		
		catch(ArithmeticException e)
		{
			throw e;
		}
		
	}
	
	/*
	 * calculateAreaOfSquare method to calculate the area of the square
	 * @param length which hold the length of square, assuming length>0
	 * @return the area of the square as a string value and up to 2 decimal points
	 */
	public String calculateAreaOfSquare(double length) throws ArithmeticException
	{
		
		try
		{
			area_result = Math.pow(length, 2);
			return decimalFormat.format(area_result);
		}
		
		catch(ArithmeticException e)
		{
			throw e;
		}
		
	}
	
}
