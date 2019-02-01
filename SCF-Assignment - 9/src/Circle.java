import java.util.Date;


public class Circle implements Shape 
{
	double radius;
	Point originPoint;
	private Date timestamp;
	
	public Circle(Point originPoint , double radius)
	{
		this.radius = radius;
		this.originPoint = originPoint;
		timestamp = new Date();
	}
	
	@Override
	public double getArea() {
		
		return Utility.PI*Math.pow(radius, 2);
		
	}

	@Override
	public double getPerimeter() {
		
		return 2*Utility.PI*radius;
		
	}

	@Override
	public Point getOrigin() {

		return originPoint;
		
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		
		return false;
		
	}

	@Override
	public Date getTimeStamp() {
		
		return timestamp;
		
	}

	@Override
	public VariousShape getShape() {
		// TODO Auto-generated method stub
		return Shape.VariousShape.Circle;
	}
}
