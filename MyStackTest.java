// http://cs-fundamentals.com/data-structures/stack-implementation-in-java.php
interface Stack <E>
{
    E getTop(); // return the top E without removing it from stack
    E pop(); // return the top E and removes it from stack
    void push(E itm); // adds an E to the stack
    boolean isEmpty(); // returns true if stack is empty, false otherwise
    int size();  // returns the number of Es in stack right now
 
}
//********************************************************************************************
//*********************************************************************************************
class ArrayStack <E> implements Stack <E>
{
    private E elements[];
    private int top;
    private final static int DEFAULT_SIZE = 10;
 
    public ArrayStack ()
    {
        this(DEFAULT_SIZE);
    }
 
    public ArrayStack (int initSize)
    {
        elements = (E[]) new Object [initSize];
        top = -1;
    }
 
    public E getTop()
    {
        if (top == -1)
            return null;
        return elements[top];
    }
 
    public boolean isEmpty()
    {
        return (top == -1);
    }
 
    public E pop()
    {
        if (top == -1)
            return null;
 
        E itm = elements[top];
        elements[top--] = null;
 
        if(top > 0 && top == elements.length / 4)
           resize (elements.length/2);
 
        return itm;
    }
 
    public void push(E itm)
    {		
        if (top == elements.length - 1)
            resize(2 * elements.length);
 
        elements[++top] = itm;
    }
 
    public int size()
    {
        return (top + 1);
    }
 
    private void resize (int newSize)
    {
        E t[] = (E[]) new Object[newSize];
        for (int i = 0; i <= top; i++)
            t[i] = elements[i];
        elements = t;
    }
 
  /*  public Iterator<E> iterator()
    {
        return new ArrayStackIterator();
    }
 
    private class ArrayStackIterator implements Iterator <E>
    {
        private int i = top;
 
        public boolean hasNext()
        {
            return (i > -1);
        }
 
        public E next()
        {
            return elements[i--];
        }
 
        public void remove()
        {
           // not needed
        }
    } */
}


public class MyStackTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack <Integer> s = new ArrayStack<Integer>();
	    s.push(20);
	    s.push(30);
	    s.push(40);
	    s.push(50);
	    s.push(60);
	    s.push(70);
	 
	    System.out.println("Size of the stack: " + s.size());
	    
	/* // iterate through stack
	    System.out.println("Following items pushed to Stack as of now:");
	    for (Integer i : s)
	      System.out.println(i);*/

	}

}
