import java.util.Date;


public class Rectangle implements Shape 
{
	private double length;
	private double height;
	private Point originPoint;
	private Date timestamp;
	
	public Rectangle(Point originPoint , double length , double height)
	{
		this.length = length;
		this.height = height;
		this.originPoint = originPoint;
		timestamp = new Date();
	}
	
	@Override
	public double getArea() {
		
		return length*height;
		
	}
	@Override
	public double getPerimeter() {
		
		return 2*(length+height);
		
	}
	@Override
	public Point getOrigin() {
		
		return originPoint;
		
	}
	@Override
	public boolean isPointEnclosed(Point point) {
		
		if(point.getxPoint() >= originPoint.getxPoint() && point.getxPoint() <= (length+originPoint.getxPoint()) 
				&& point.getyPoint() >= originPoint.getyPoint() && point.getyPoint() <= (height+originPoint.getyPoint()))
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
		return Shape.VariousShape.Rectangle;
	}
}
