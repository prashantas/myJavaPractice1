package RiaPack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node1 {
	int key;
	Node1 left;
	Node1 right;
	public Node1(int key){
		this.key =key;
	}
	@Override
	public String toString() {
		return "[key=" + key + "]";
	}
	
}
class BST {
	Node1 root;
	public void addNode(int key)
	{
		Node1 node =  new Node1(key);
		if(root==null)
			root=node;
		else
		{
			Node1 focusNode = root;
			Node1 parent;
			while(true)
			{
				parent = focusNode ;
				if(key < focusNode.key)
				{
					focusNode = focusNode.left;
					if(focusNode==null)
					{
						 parent.left = node;
						 return;
					}
				}
				else  // key > focusNode.right
				{
					focusNode = focusNode.right;
					if(focusNode==null)
					{
						parent.right=node;
						return;
					}
				}
			}
		}
	}
	
	public void Inorder(Node1 root)
	{
		
		if(root!=null){
			Inorder(root.left);
			System.out.print(root);
			Inorder(root.right);
		}
		
	}
	public ArrayList<Integer> InorderNonRecursive(Node1 root)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root==null) return result ;
		Stack<Node1> stack = new Stack<Node1>();
		
		Node1 p = root;
		
		while(!stack.isEmpty() || p!=null)
		{
			if(p!=null)
			{
				stack.push(p);
				p=p.left;
			}
			else
			{
				Node1 n = stack.pop();
				result.add(n.key);
				p = n.right;
			}
		}
		return result;
	}
	
	public void Preorder(Node1 root)
	{
		if(root!=null){
			System.out.print(root);
			Preorder(root.left);
			Preorder(root.right);
		}
	}
	
	public void Postorder(Node1 root)
	{
		if(root!=null){
			
			Postorder(root.left);
			Postorder(root.right);
			System.out.print(root);
		}
	}
	public ArrayList<Integer> PreorderNonRecursion(Node1 root)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root==null) return result ;
		Stack<Node1> stack = new Stack<Node1>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			Node1 n = stack.pop();
			result.add(n.key);
			if(n.right!=null)
				stack.push(n.right);
			if(n.left!=null)
				stack.push(n.left);
		}
		return result;
	}
	
	/* print level wise nodes in the binary tree (Breadth First Traversal) */
	public void BreathFirst(Node1 root)
	{
		if(root==null) return ;
		Queue<Node1> q = new LinkedList<Node1>();
		
		q.offer(root);
		while(q.size()>0)
		{
			Node1 n = q.poll();
			System.out.print(" "+ n.key);
			if(n.left!=null)  q.offer(n.left);
			if(n.right!=null)  q.offer(n.right);
		}
	}
	
	//another imp link : http://www.geeksforgeeks.org/reverse-level-order-traversal/
	public void BreadthFirstNewLine(Node1 root)
	{
		if(root==null) return ;
		Queue<Node1> q = new LinkedList<Node1>();
		
		q.add(root);
		while(q.size()>0)
		{
			int size = q.size();
			for(int i=0;i<size;i++)
			{
				Node1 n = q.remove();
				System.out.print(" "+n.key);
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
			}
			System.out.println("");
		}
	}
	
	public  void breadthFirstEachLevelNewLineSpiralView(Node1 root)
	{ // http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
		if(root==null) return;
		Stack<Node1> s1 = new Stack<Node1>();
		Stack<Node1> s2 = new Stack<Node1>();
		
		s1.push(root);
		while(!s1.isEmpty() || !s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				Node1 n = s1.pop();
				System.out.print(" " + n.key);
				if(n.right!=null) s2.push(n.right);
				if(n.left!=null)  s2.push(n.left);
			}
			System.out.println();
			while(!s2.isEmpty())
			{
				Node1 p = s2.pop();
				System.out.print(" "+ p.key);
				if(p.left!=null) s1.push(p.left);
				if(p.right!=null) s1.push(p.right);
			}
			System.out.println();
		}
		
	}
	
	/* reflection of a tree i.e mirror image of tree Iterative
	 * http://stackoverflow.com/questions/4366251/mirror-image-of-a-binary-tree */
	public  void reflectionIterative(Node1 root)
	{
		if(root==null) return;
		Queue<Node1> q = new LinkedList<Node1>();
		q.add(root);
		
		while(q.size()>0)
		{
			Node1 n = q.remove();
			if(n.left==null && n.right==null)
				continue;
			if(n.left!=null && n.right!=null)
			{
				Node1 tmp = n.left;
				n.left= n.right;
				n.right= tmp;
				q.add(n.left);
				q.add(n.right);
			}
			else if(n.left!=null)
			{
				n.right = n.left;
				n.left= null;
				q.add(n.right);
				
			}
			else if(n.right!= null)
			{
				n.left = n.right;
				n.right = null;
				q.add(n.left);
			}
		}
	}
	
	public Node1 FindNode(int key)
	{
		Node1 fn = root;
		while(fn.key!=key)
		{
			if(key < fn.key)
				fn = fn.left;
			else
				fn = fn.right;
			if(fn ==null) return null;
		}
		
		return fn;
	}
	public boolean isBST(Node1 root, double min, double max)
	{
		if(root==null) return true;
		if(root.key <= min || root.key >= max) return false;
		return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
	}
	public boolean isBST(Node1 root)
	{
		return isBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}
	
	// http://codereview.stackexchange.com/questions/6774/check-if-a-binary-tree-is-a-subtree-of-another-tree
	public boolean equals(Node n1, Node n2) {
    		if (n1 == n2) return true;
    		if (n1 == null || n2 == null) return false;
		 if (n1.data != n2.data) return false; // Should use .equals if Node.data isn't primitive
    			return equals(n1.left, n2.left) && equals(n1.right, n2.right);
	}

	public boolean isSubtree(Node n1, Node n2) {
		 if (n2 == null) return true;
    		if (n1 == null) return false;
    		return equals(n1, n2) || isSubtree(n1.left, n2) || isSubtree(n1.right, n2);
	}
	
}

public class BinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        BST bt =  new BST();
        bt.addNode(50);
		bt.addNode(25);
		bt.addNode(15);
		bt.addNode(30);
		bt.addNode(75);
		bt.addNode(85);
		bt.addNode(60);
		//            50
		//       25		  75
		//    15    30   60   85
		System.out.print("Inorder::");
		bt.Inorder(bt.root); System.out.println("PostOrder::");
		bt.Postorder(bt.root);System.out.println("PreOrder::");
		bt.Preorder(bt.root);System.out.println("");
		/*System.out.println("InorderWithoutRecursion::"+ bt.InorderNonRecursive(bt.root));
		System.out.println("PreorderWithoutRecursion::"+ bt.PreorderNonRecursion(bt.root));
		System.out.println("BreadthFirst::");
		bt.BreathFirst(bt.root); System.out.println("");
		System.out.println("BreadthFirstNewLine::");
		bt.BreadthFirstNewLine(bt.root);System.out.println("");
		System.out.println("BreadthFirstNewLine(Spiral)::");
		bt.breadthFirstEachLevelNewLineSpiralView(bt.root);
		bt.reflectionIterative(bt.root);
		System.out.println("BreadthFirstNewLine ( after doing reflection)::");
		bt.BreadthFirstNewLine(bt.root);System.out.println("");*/
		
		
	}

}
