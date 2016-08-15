/* Functionality: 1)Tree Creation: * User will be asked to enter number of nodes and 
 * values of each node. * User has to enter data using keyboard.
 *  * N-ary tree will be created based on data given by user. 
 *  2)Conditions considering while tree creation: * All child values will be less 
 *  than parent value. * All sibling values will be greater than previous siblings. 
 *  * As Root node is parent of all nodes it will have maximum value. 3)N-ary tree structure:
 *   * each node will have info regarding first child and next sibling.
 *    * Root can't have siblings. * user can enter as many nodes as he want.
 *     * Any node can have any number of childs or siblings( Root can have only childs)
 *      4)Output: * User can see created tree information imediately or can save it in fil e. 
 *      * user can get tree stucture in 3 formats: Inorder,Preorder,Postorder.
 *       * User can give ouput file name while saving output in file. */
/***********************************************************************************
 #include<stdlib.h>
 #include<stdio.h>
 #include<string.h> 
 struct tree_el { // n-ary tree node definition int val; struct tree_el * sibling, * child; };
 typedef struct tree_el node;
 void insert(node ** tree, node * item)
 { 
 // Function to insert new node 
  if(!(*tree)) { *tree = item; // Root Node insertion
   		return; }
  if(item->val<(*tree)->val) // child node inserion 
  		insert(&(*tree)->child, item);
  else if(item->val>(*tree)->val) // sibling node insertion 
  	insert(&(*tree)->sibling, item);
 } 
  	
 void print_node_info(node * tree)
 { // Function to print node information: Node value,Node first child,Node next sibling 
 	if(tree->child && tree->sibling)
 	 { 
 	 	printf("%d, parent of %d and sibling of %d\n",tree->val, (tree->child) ->val,(tree->sibling)->val);
 	 } else 
 	 if (tree->child) {
 	  printf("%d, parent of %d\n",tree->val, (tree->child)->val);
 	  } else if (tree->sibling)
 	   	{
 	   	 printf("%d, sibling of %d\n",tree->val,(tree->sibling)->val);
 	   	} else printf("%d\n",tree->val);
 } 	
 
 void in_order_print(node * tree)
 { // Function to print Node information in Inor der
  	if(tree->child) 
  		in_order_print(tree->child);
  	 print_node_info(tree);
  	 if(tree->sibling)
  	  	in_order_print(tree->sibling); 
 } 
 
 void pre_order_print(node * tree) 
 { // Function to print Node information in pre order 
 print_node_info(tree); 
 if(tree->child) pre_order_print(tree->child); 
 if(tree->sibling) pre_order_print(tree->sibling);
 } 
 
 void post_order_print(node * tree) 
 { // Function to print Node information in po storder
  if(tree->child) post_order_print(tree->child);
  if(tree->sibling) post_order_print(tree->sibling);
  print_node_info(tree);
 }
 	 

 
 **********************************************************************************/

public class NaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
