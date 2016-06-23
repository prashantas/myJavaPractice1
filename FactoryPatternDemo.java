package RiaPack;

class Rectangle implements Shape
{
	public void draw()
	{
		System.out.println("inside Rectangle");
	}
}
class Circle implements Shape
{
	public void draw()
	{
		System.out.println("inside Circle");
	}
}
class Square implements Shape
{
	public void draw()
	{
		System.out.println("inside Square");
	}
}

class ShapeFactory
{
	public Shape getShape(String shapeType)
	{
		if(shapeType==null){ return null; }
		if(shapeType.equalsIgnoreCase("CIRCLE"))
		{
			return new Circle();
		}
		else if(shapeType.equalsIgnoreCase("RECTANGLE"))
		{
			return new Rectangle();
		}
		else if(shapeType.equalsIgnoreCase("SQUARE"))
		{
			return new Square();
		}
	
	
	return null;
	}
}

public class FactoryPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ShapeFactory shapefactory = new ShapeFactory();
			Shape shapeRec  = shapefactory.getShape("rectangle");
			shapeRec.draw();
	}

}
