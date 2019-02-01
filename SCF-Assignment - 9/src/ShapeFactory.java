import java.util.List;


public class ShapeFactory 
{
	public static Shape getShapeObject(String shape , Point originPoint, List<Integer> parameterList) throws Exception
	{
		Shape.VariousShape shapeEnum = Shape.VariousShape.valueOf(shape);
		
		if(shapeEnum == Shape.VariousShape.Circle)
		{
			if(parameterList.size()<1)
				throw new Exception("Invalid parameters!!!");
			return new Circle(originPoint , parameterList.get(0));
		}
		else if(shapeEnum == Shape.VariousShape.Rectangle)
		{
			if(parameterList.size()<2)
				throw new Exception("Invalid parameters!!!");
			return new Rectangle(originPoint , parameterList.get(0) , parameterList.get(1));
		}
		else if(shapeEnum == Shape.VariousShape.Square)
		{
			if(parameterList.size()<1)
				throw new Exception("Invalid parameters!!!");
			return new Square(originPoint , parameterList.get(0));
		}
		else if(shapeEnum == Shape.VariousShape.Triangle)
		{
			return new Triangle();
		}
		else if(shapeEnum == Shape.VariousShape.RegularPolygon)
		{
			return new RegularPolygon();
		}
		return null;
	}
}
