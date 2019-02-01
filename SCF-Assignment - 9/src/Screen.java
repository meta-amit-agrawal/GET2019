import java.util.ArrayList;
import java.util.List;


public class Screen 
{
	double X_Max;
	double Y_Max;
	
	List<Shape> shapeList;
	
	public Screen(double x_max , double y_max)
	{
		X_Max = x_max;
		Y_Max = y_max;
		shapeList = new ArrayList<Shape>();
	}
	
	
	public Shape isShapeAvailable(Shape.VariousShape shape , Point originPoint)
	{
		for(int i=0; i<shapeList.size(); i++)
		{
			Shape existingShape = shapeList.get(i);
			Point origin = existingShape.getOrigin();
			
			if(shape == existingShape.getShape() && 
					origin.getxPoint() == originPoint.getxPoint()
					&& origin.getyPoint() == originPoint.getyPoint())
			{
				return existingShape;
			}
			
		}
		return null;
	}
	
	public boolean addShape(String shape , Point originPoint , List<Integer> parameterList) throws Exception
	{
			if(shape == null)
				throw new Exception("Shape cannot be null");
			
			Shape shapeType = ShapeFactory.getShapeObject(shape,originPoint,parameterList);
			if(shapeList.add(shapeType))
			System.out.println("Added");
			return true;
		
	}
	
	
	public boolean deleteShape(String shape , Point originPoint) throws Exception 
	{
		if(shape == null)
			throw new Exception("Shape cannot be null");
		
		Shape.VariousShape shapeEnum = Shape.VariousShape.valueOf(shape);
		
		Shape foundShape = isShapeAvailable(shapeEnum , originPoint);
		
		if(foundShape == null)
			throw new Exception("Shape Not found");
		
		shapeList.remove(foundShape);
		System.out.println("Deleted");
		return true;
		
	}
	
	public boolean deleteAllShape(String shape) throws Exception
	{
		if(shape == null)
			throw new Exception("Shape Cannot be Null");
		
		List<Shape> deleteShape = new ArrayList<Shape>();
		
		Shape.VariousShape shapeEnum = Shape.VariousShape.valueOf(shape);
		
		for(int i=0;i<shapeList.size(); i++)
		{
			Shape existingShape = shapeList.get(i);
			if(shapeEnum == existingShape.getShape())
			{
				deleteShape.add(existingShape);
			}
		}
		
		for(Shape s : deleteShape)
		{
			shapeList.remove(s);
			System.out.println("Deleted");
		}
		
		return true;
	}
	
	public static void main(String args[])
	{
		Screen screen= new Screen(100,100);
		ArrayList<Integer> parameter = new ArrayList<Integer>();
		parameter.add(2);
		parameter.add(3);
		try {
			screen.addShape("Square", new Point(1,3),parameter);
			screen.addShape("Rectangle", new Point(1,3),parameter);
			screen.addShape("Square", new Point(2,3),parameter);
			screen.addShape("Square", new Point(4,3),parameter);
			screen.deleteAllShape("Square");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		for(int i=0;i<screen.shapeList.size();i++)
		{
			Shape s = screen.shapeList.get(i);
			System.out.println(s.getShape()+"  "+s.getArea()+"  "+s.getPerimeter()+"  "+s.getOrigin().xPoint);
		}
		
	}
	
}
