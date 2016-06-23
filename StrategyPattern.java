package RiaPack;
/* http://www.tutorialspoint.com/design_pattern/strategy_pattern.htm */

/*public interface Strategy
{
	public int doOperation(int a , int b);
}*/

class AddOperation implements Strategy
{
	public int doOperation(int a, int b)
	{
		return a+b ;
	}
}

class SubOperation implements Strategy
{
	public int doOperation( int a, int b)
	{
		return a - b ;
	}
}

class MulOperation implements Strategy
{
	public int doOperation ( int a , int b)
	{
		 return a*b;
	}
}

class Context
{
	private Strategy strategy ;
	public Context(Strategy strategy)
	{
		this.strategy = strategy;
	}
	
	public int executeStrategy(int a, int b)
	{
		return strategy.doOperation(a, b);
	}
}
public class StrategyPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Context context =  new Context(new AddOperation());
		System.out.println("10+5="+ context.executeStrategy(10,5));
		context = new Context(new SubOperation());
		System.out.println("10-5="+ context.executeStrategy(10,5));
		context = new Context(new MulOperation());
		System.out.println("10*5="+ context.executeStrategy(10,5));
	}

}
