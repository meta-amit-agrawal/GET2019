import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Screen 
{
	double X_Max;
	double Y_Max;
	
	List<Shape> shapeList;
	
	//parameterized constructor to initialize the maximum coordinate of the screen 
	public Screen(double x_max , double y_max)
	{
		X_Max = x_max;
		Y_Max = y_max;
		shapeList = new ArrayList<Shape>();
	}
	
	public Point getMaxScreen()
	{
		Point point = new Point(X_Max, Y_Max);
		return point;
	}
	
	
	/*
	 * isShapeAvailable method to check whether the shape with the origin point is available on the screen or not
	 * @param requires the shape of type enum 
	 * @param requires the origin point of the shape to be searched for
	 * @return the object of the shape interface if found or else will return null
	 */
	public Shape isShapeAvailable(Shape.VariousShape shape , Point originPoint)
	{
		for(int i=0; i<shapeList.size(); i++)
		{
			Shape existingShape = shapeList.get(i);
			Point origin = existingShape.getOrigin();
			
			//checking the shape at given origin point is available or not 
			if(shape == existingShape.getShape() && 
					origin.getxPoint() == originPoint.getxPoint()
					&& origin.getyPoint() == originPoint.getyPoint())
			{
				return existingShape;
			}
			
		}
		return null;
	}
	
	
	/*
	 * addShape method to add the shape on the screen
	 * @param requires the shape of string type 
	 * @param requires the origin point of the shape to be added of the screen
	 * @return true if shape is added on screen or @throws an exception
	 */
	public boolean addShape(String shape , Point originPoint , List<Integer> parameterList) throws Exception
	{
			if(shape == null)
				throw new Exception("Shape cannot be null");
			
			//getting the object from the factory class
			Shape shapeType = ShapeFactory.getShapeObject(shape,originPoint,parameterList,getMaxScreen());
			if(shapeList.add(shapeType))
			System.out.println("Added");
			return true;
		
	}
	
	/*
	 * deleteShape method to delete the specific shape with the origin point of the shape
	 * @param requires the shape of type string 
	 * @param requires the origin point of the shape to be added on screen
	 * @return true if shape is added on the screen
	 */
	public boolean deleteShape(String shape , Point originPoint) throws Exception 
	{
		if(shape == null)
			throw new Exception("Shape cannot be null");
		
		//converting the string value to the enum value
		Shape.VariousShape shapeEnum = Shape.VariousShape.valueOf(shape);
		
		//checking the shape is available or not
		Shape foundShape = isShapeAvailable(shapeEnum , originPoint);
		
		if(foundShape == null)
			throw new Exception("Shape Not found");
		
		shapeList.remove(foundShape);
		System.out.println("Deleted");
		return true;
		
	}
	
	
	/*
	 * deleteAllShape method deletes all shape of specific type
	 * @param requires the shape 
	 * @return the true value if all shapes are deleted
	 */
	public boolean deleteAllShape(String shape) throws Exception
	{
		if(shape == null)
			throw new Exception("Shape Cannot be Null");
		
		List<Shape> deleteShape = new ArrayList<Shape>();
		
		Shape.VariousShape shapeEnum = Shape.VariousShape.valueOf(shape);
		
		//add the shape of a specific type to a new arraylist
		for(int i=0;i<shapeList.size(); i++)
		{
			Shape existingShape = shapeList.get(i);
			if(shapeEnum == existingShape.getShape())
			{
				deleteShape.add(existingShape);
			}
		}
		
		//deleting the shape of specific type from the shape list
		for(Shape s : deleteShape)
		{
			shapeList.remove(s);
			System.out.println("Deleted");
		}
		
		return true;
	}
	
	/*
	 * sortList method to sort the list according to the user choice
	 * @param requires the choice of the user for sorting
	 * @returns the sorted list
	 */
	public List<Shape> sortList(String choice) throws Exception
	{
		switch(choice)
		{
		case "area":
			Collections.sort(shapeList, Sorting.areaComparator);
			break;
		case "perimeter":
			Collections.sort(shapeList, Sorting.perimeterComparator);
			break;
		case "origin":
			Collections.sort(shapeList, Sorting.originDistanceComparator);
			break;
		case "timestamp":
			Collections.sort(shapeList, Sorting.timestampComparator);
			break;
		default:
			throw new Exception("Invalid choice");
		}
		return null;
	}
	
	/*
	 * shapeEnclosingPoint checks all shape that are present whether enclosing the point or not
	 * @param requires the point to be checked
	 * @returns the list of shapes which are enclosing the point
	 */
	public List<Shape> shapeEnclosingPoint(Point point)
	{
		List<Shape> enclosedShape = new ArrayList<Shape>();
		for(int i=0;i<shapeList.size();i++)
		{
			Shape shape = shapeList.get(i);
			if(shape.isPointEnclosed(point))
			{
				enclosedShape.add(shape);
			}
		}
		return enclosedShape;
	}
	
	
	
}
