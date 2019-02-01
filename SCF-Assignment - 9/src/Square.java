import java.util.Date;


public class Square implements Shape
{
	private double lengthOfSide;
	private Point originPoint;
	private Date timestamp;
	
	public Square(Point originPoint, double lengthOfSide)
	{
		this.lengthOfSide = lengthOfSide;
		this.originPoint = originPoint;
		timestamp = new Date();
	}

	@Override
	public double getArea() {
	
		return Math.pow(lengthOfSide, 2);
		
	}

	@Override
	public double getPerimeter() {
		
		return 4*lengthOfSide;
		
	}

	@Override
	public Point getOrigin() {
		
		return originPoint;
		
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		
		if(point.getxPoint() >= originPoint.getxPoint() && point.getxPoint() <= (lengthOfSide+originPoint.getxPoint()) 
				&& point.getyPoint() >= originPoint.getyPoint() && point.getyPoint() <= (lengthOfSide+originPoint.getyPoint()))
			return true;
		
		return false;
		
	}

	@Override
	public Date getTimeStamp() {
		
		return timestamp;
	}

	@Override
	public VariousShape getShape() {
		// TODO Auto-generated method stub
		return Shape.VariousShape.Square;
	}
	
	
	
}
