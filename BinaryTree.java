package RiaPack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// http://www.newthinktank.com/2013/03/binary-tree-in-java/

class Node
{
	
	int key;
	String name;
	Node left;
	Node right;
	public Node(int key, String name) {		
		this.key = key;
		this.name = name;
	}
	@Override
	public String toString() {
		return name + "has the key:" + key;
	}
	
}


public class BinaryTree {
	Node root;
	public void addNode(int key, String name)
	{
		Node node = new Node(key, name);
		if(root==null)
			root = node;
		else
		{
			Node focusNode = root;
			Node parent;
			while(true)
			{
				parent = focusNode;
				if(key < focusNode.key)
				{
					focusNode = focusNode.left;
					if(focusNode==null)
					{		
						parent.left = node;
						return ;
					}	
				}
				else
				{
					focusNode = focusNode.right;
					if(focusNode==null)
					{		
						parent.right = node;
						return ;
					}
				}
			}
		}
	}
	
	public void inorderTraverse(Node focusNode)
	{
		if(focusNode!=null)
		{
			inorderTraverse(focusNode.left);
			System.out.println(focusNode);
			inorderTraverse(focusNode.right);
		}
	}
	
	public ArrayList<Integer> inorderTraverseWithoutRecursion(Node root)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if(root==null)
			return result;
		Stack<Node> stack = new Stack<Node>();
		
		Node p = root;
		
		while(!stack.empty() || p!=null)
		{
			if(p!=null)
			{
				stack.push(p);
				p = p.left;
			}
			else
			{
				Node n = stack.pop();
				result.add(n.key);
				p= n.right;
			}
		}
		return result;
	}
    
	public void preorderTraverse(Node focusNode)
	{
		if(focusNode!=null)
		{
			System.out.println(focusNode);
			preorderTraverse(focusNode.left);			
			preorderTraverse(focusNode.right);
		}
	}
	
	// http://www.programcreek.com/2012/12/leetcode-solution-for-binary-tree-preorder-traversal-in-java/
	public ArrayList<Integer> preorderTraverseWithoutRecursion(Node root)
	{
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if(root==null)
			return result;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		
		while(!stack.empty())
		{
			Node n = stack.pop();
			result.add(n.key);
			
			if(n.right!=null)
				stack.push(n.right);
			if(n.left!=null)
				stack.push(n.left);
		}
		
		return result;
	}
	
	public void postorderTraverse(Node focusNode)
	{
		if(focusNode!=null)
		{
			postorderTraverse(focusNode.left);			
			postorderTraverse(focusNode.right);
			System.out.println(focusNode);
		}
	}
	
	/* print level wise nodes in the binary tree (Breadth First Traversal) */
	public static void breadthFirstNonRecursive(Node root)
	{
		if(root==null) return;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		while(q.size()> 0)
		{
			Node nd = q.poll();
			System.out.print(" " + nd.key);
			if(nd.left!=null)
				q.offer(nd.left);
			if(nd.right!=null)
				q.offer(nd.right);
		}
	}
	
	//another imp link : http://www.geeksforgeeks.org/reverse-level-order-traversal/
	public static void breadthFirstEachLevelNewLine(Node root)
	{
		if(root==null) return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(q.size()>0)
		{
			int size = q.size();
			
			for(int i=0;i<size;i++)
			{
				Node nd = q.remove();
				System.out.print(" "+ nd.key);
				if(i==(size-1))
					System.out.println("");
				if(nd.left!=null)
					q.add(nd.left);
				if(nd.right!=null)
					q.add(nd.right);
			}
		}
		
	}
	
	public static void breadthFirstEachLevelNewLineSpiralView(Node root)
	{ // http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
		if(root==null) return;
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		s1.push(root);
		while(!s1.isEmpty() || !s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
			   Node nd = s1.pop();
			   System.out.print(nd.key + " ");
			   if(nd.right!=null)
				   s2.push(nd.right);
			   if(nd.left!=null)
				   s2.push(nd.left);
			}	
			System.out.println("");
			
			while(!s2.isEmpty())
			{
				Node nd = s2.pop();
				   System.out.print(nd.key + " ");
				if(nd.left!=null)
					s1.push(nd.left);
				if(nd.right!=null)
					s1.push(nd.right);
			}
			System.out.println("");
		}
		
	}
	/* reflection of a tree i.e mirror image of tree Iterative
	 * http://stackoverflow.com/questions/4366251/mirror-image-of-a-binary-tree */
	public static void reflectionIterative(Node root)
	{
		if(root==null) return ;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(q.size()>0)
		{
			Node nd = q.remove();
			if(nd.left==null && nd.right==null)
				continue;
			if(nd.left!=null && nd.right!=null)
			{
				Node tmp = nd.left;
				nd.left=nd.right;
				nd.right=tmp;
				q.add(nd.left);
				q.add(nd.right);
			}
			else if(nd.left!=null)
			{
				nd.right= nd.left;
				nd.left=null;
				q.add(nd.right);
			}
			else
			{
				nd.left=nd.right;
				nd.right=null;
				q.add(nd.left);
			}
			
		}
		
	}
	
	public Node findNode( int key)
	{
		Node focusNode = root;
		while(focusNode.key!=key)
		{
			if(key< focusNode.key)
				focusNode = focusNode.left;
			else
				focusNode = focusNode.right;
			if(focusNode==null)
				return null;
		}
		
		return focusNode;
	}
	public static boolean isBST(Node root, double min, double max)
	{
		if(root==null) return true;
		if(root.key<=min || root.key>=max) return false;
		
		return isBST(root.left, min, root.key) && isBST( root.right, root.key, max);
	}
	/*
	 * This solution also goes to the left subtree first. If the violation occurs 
	 * close to the root but on the right subtree, the method still cost O(n). 
	 * The second solution below can handle violations close to root node faster.
	 */
	public static boolean isBST(Node root)
	{
		return isBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.addNode(50,"boss");
		bt.addNode(25, "vp");
		bt.addNode(15,"om");
		bt.addNode(30, "sec");
		bt.addNode(75, "sm");
		bt.addNode(85, "sm1");
		bt.addNode(60, "sm2");
		//            50
		//       25		  75
		//    15    30   60   85
		//bt.inorderTraverse(bt.root);
		//bt.preorderTraverse(bt.root);
		//ArrayList<Integer> arr = bt.preorderTraverseWithoutRecursion(bt.root);
		//System.out.println("preorderWithoutRecursion:" + arr);
		//System.out.println("inorderWithoutRecursion:" + bt.inorderTraverseWithoutRecursion(bt.root));
		//System.out.println(bt.findNode(75));
		//breadthFirstNonRecursive(bt.root);
		System.out.println("");
		//reflectionIterative(bt.root);
		
		breadthFirstEachLevelNewLine(bt.root);
		System.out.println("Spiral view");
		breadthFirstEachLevelNewLineSpiralView(bt.root);
		System.out.println("IsBST testing ::" + isBST(bt.root));
	}

}
