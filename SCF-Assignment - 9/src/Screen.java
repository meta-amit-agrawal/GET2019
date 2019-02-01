import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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
	
	public static Comparator<Shape> areaComparator = new Comparator<Shape>() {

		@Override
		public int compare(Shape o1, Shape o2) {
			double area1 = o1.getArea();
			double area2 = o2.getArea();
			
			if(area1 > area2)
				return 1;
			else if(area1 < area2)
				return -1;
			else
				return 0;
		}
		
	};
	
	
	public static Comparator<Shape> perimeterComparator = new Comparator<Shape>() {

		@Override
		public int compare(Shape o1, Shape o2) {
			double peri1 = o1.getPerimeter();
			double peri2 = o2.getPerimeter();
			
			if(peri1 > peri2)
				return 1;
			else if(peri1 < peri2)
				return -1;
			else
				return 0;
		}
		
	};
	
	public static Comparator<Shape> timestampComparator = new Comparator<Shape>() {

		@Override
		public int compare(Shape o1, Shape o2) {
			Date time1 = o1.getTimeStamp();
			Date time2 = o2.getTimeStamp();
			
			if(time1.after(time2))
				return -1;
			else if(time1.before(time2))
				return 1;
			else
				return 0;
				
		}
		
	};
	
	public static Comparator<Shape> originDistanceComparator = new Comparator<Shape>() {

		@Override
		public int compare(Shape o1, Shape o2) {
			double distance1 = o1.originDistance();
			double distance2 = o2.originDistance();
			
			if(distance1 > distance2)
				return 1;
			else if(distance1 < distance2)
				return -1;
			else
				return 0;
				
		}
		
	};
	
	
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
			
			System.out.println(e.getMessage());
		}
		
		for(int i=0;i<screen.shapeList.size();i++)
		{
			Shape s = screen.shapeList.get(i);
			System.out.println(s.getShape()+"  "+s.getArea()+"  "+s.getPerimeter()+"  "+s.getOrigin().xPoint+"  "+s.getTimeStamp());
		}
		
	}
	
}
