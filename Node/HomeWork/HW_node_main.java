import ClassWork.Node;
import java.util.Scanner;

public class HW_nodes_main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);	
		
		Node<Integer> chain2 = null;  
		int [] arr = {1,2,3,4,5,6};		
		for (int i = 0; i< 3; i++) 
		{// insert Node
			System.out.println("enter " + (i+1) + " value of chain");
			chain2 = new Node<Integer>(in.nextInt(), chain2);
		}
		
		
// printNode(chain2);       // toString()
// Node<Integer> myNode = createNode(arr);  // create Node from array
// printNode(myNode);
		
// in function addFirst if we will not return Node we could be loose our NodeList => O(n)
	
		 Node<Integer> newChain = addFirst(chain2, 5555);  
		 printNode(newChain);

	}
	
	public static  void printNode(Node<Integer> Chain) { // fun toSting Nodes in chain	
		Node<Integer> pos = Chain;
		if (pos == null)
			return;
		else
		{
			printNode(pos.getNext());
			System.out.print(pos.getvalue() + ", ");
		}
		
	}

	public static Node<Integer> createNode(int [] arr) { // fun to create Node from array
		Node<Integer> myNode = null;	
		for(int i=0; i< arr.length; i++)
			myNode = new Node<Integer>(arr[i],myNode);
		
		return myNode;
	}

	public static Node<Integer> addFirst(Node<Integer> chain2 , int n){ // fun to add value to first element
		
		Node<Integer> pos = new Node<Integer>(n,chain2);		
		return pos;
	}
	
}
 

