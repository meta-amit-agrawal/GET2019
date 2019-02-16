import java.util.List;


public class ShapeFactory 
{
	
	public static Shape getShapeObject(String shape , Point originPoint, List<Integer> parameterList , Point screenMaxPoint) throws Exception
	{
		
		//checks the origin of the shape is lying in the screen or not
		if(originPoint.getxPoint() > screenMaxPoint.getxPoint() || originPoint.getyPoint() > screenMaxPoint.getyPoint()
				|| originPoint.getxPoint() < 0 || originPoint.getyPoint()<0)
			throw new Exception("Origin point should be lies in screen range!!!");
		
		//converting the string type to the enum
		Shape.VariousShape shapeEnum = Shape.VariousShape.valueOf(shape);
		
		
		//checking for the shape type to make an object of specific type
		if(shapeEnum == Shape.VariousShape.Circle)
		{
			//checking the minimum parameter required
			if(parameterList.size()<1)
				throw new Exception("Invalid parameters!!!");
			
			return new Circle(originPoint , parameterList.get(0));
			
		}
		else if(shapeEnum == Shape.VariousShape.Rectangle)
		{
			//checking the minimum parameter required
			if(parameterList.size()<2)
				throw new Exception("Invalid parameters!!!");
			
			return new Rectangle(originPoint , parameterList.get(0) , parameterList.get(1));
			
		}
		else if(shapeEnum == Shape.VariousShape.Square)
		{
			//checking the minimum parameter required
			if(parameterList.size()<1)
				throw new Exception("Invalid parameters!!!");
			
			return new Square(originPoint , parameterList.get(0));
			
		}
		else if(shapeEnum == Shape.VariousShape.Triangle)
		{
			//checking the minimum parameter required
			if(parameterList.size()<2)
				throw new Exception("Invalid parameters!!!");
			
			return new Triangle(originPoint , parameterList.get(0) , parameterList.get(1));
			
		}
		else if(shapeEnum == Shape.VariousShape.RegularPolygon)
		{ 
			//checking the minimum parameter required
			if(parameterList.size()<4)
				throw new Exception("Invalid parameters!!!");
			
			return new RegularPolygon(originPoint , parameterList.get(0) , parameterList.size());
			
		}
		return null;
	}
}
