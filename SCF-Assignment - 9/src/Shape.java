import java.util.Date;


public interface Shape {
	
	public double getArea();
	
	public double getPerimeter();
	
	public Point getOrigin();
	
	public boolean isPointEnclosed(Point point);
	
	public Date getTimeStamp();
	
	public Shape.VariousShape getShape();
	
	public double originDistance();
	
	
	enum VariousShape
	{
		Square,Rectangle,Circle,Triangle,RegularPolygon;
	}
	
}
