// http://algorithms.tutorialhorizon.com/given-two-binary-trees-check-if-one-binary-tree-is-a-subtree-of-another/
// http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
// http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
public class BinarytreeisSubTreeOfAnother {
//store the inOrder and postorder traversal for both the array, 
//if one array is the sub array of another array, that means one tree is the subtree
	//of another one
	/*public String inOrder(Node root, String i){
		if(root!=null){
			return inOrder(root.left,i) + "  " + root.data + "  " +inOrder(root.right,i);
		}
		return "";
	}
	public String postOrder(Node root, String i){
		if(root!=null){
			return  postOrder(root.left,i) + "  " + postOrder(root.right,i) + "  " + root.data;
		}
		return "";
	}*/
	
	public String inOrder(Node root){
		if(root!=null){
			//System.out.println(inOrder(root.left) + "  " + root.data + "  " +inOrder(root.right));
			return inOrder(root.left) + "  " + root.data + "  " +inOrder(root.right);
		}
		return "";
	}
	public String postOrder(Node root){
		if(root!=null){
			return  postOrder(root.left) + "  " + postOrder(root.right) + "  " + root.data;
		}
		return "";
	}
	
	public boolean checkSubtree(Node rootA, Node rootB){
		/*String inOrderA = inOrder(rootA,"");
		String inOrderB = inOrder(rootB,"");
		String postOrderA = postOrder(rootA,"");
		String postOrderB = postOrder(rootB,"");*/
		
		String inOrderA = inOrder(rootA);
		String inOrderB = inOrder(rootB);
		String postOrderA = postOrder(rootA);
		String postOrderB = postOrder(rootB);
		
		System.out.println("inOrderA::" + inOrderA);
		System.out.println("inOrderB::" + inOrderB);
		System.out.println("postOrderA::" + postOrderA);
		System.out.println("postOrderB::" + postOrderB);
		return (inOrderA.toLowerCase().contains(inOrderB.toLowerCase()) && postOrderA.toLowerCase().contains(postOrderB.toLowerCase()));
	}
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Node rootA = new Node(1);
		rootA.left = new Node(2);
		rootA.right = new Node(4);
		rootA.left.left = new Node(3); 
		rootA.right.right = new Node(6);
		rootA.right.left = new Node(5); 
		Node rootB = new Node(4);
		rootB.left = new Node(5);
		rootB.right = new Node(6); 
		BinarytreeisSubTreeOfAnother i  = new BinarytreeisSubTreeOfAnother();
		System.out.print(" Tree A : ");
		i.display(rootA);
		System.out.println();
		System.out.print(" Tree B : ");
		i.display(rootB);
		System.out.println();
	System.out.println(i.checkSubtree(rootA,rootB));
	}
}
class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

