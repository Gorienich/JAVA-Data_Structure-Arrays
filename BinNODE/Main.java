package BinNODE;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {1,2,3,4,5,6,7};
		
		BinNode<Integer> myChain = createChainFromArray(arr);
		System.out.println(getMiddle(myChain).toString());

		
	}
	
	// function to create biNode from array with correct position of indexes in array line 
	public static BinNode<Integer> createChainFromArray(int[] arr) {
	    BinNode<Integer> head = null;
	    BinNode<Integer> prevNode = null;
	    
	    for (int i = 0; i < arr.length; i++) {
	        BinNode<Integer> node = new BinNode<>(arr[i]);
	        if (prevNode != null) {
	            prevNode.setRight(node);
	            node.setLeft(prevNode);
	        } else {
	            head = node;
	        }
	        prevNode = node;
	    }
	    return head;
	}
	
	// Recursion to find node by value
	public static BinNode<Integer> findNodeWithValue (BinNode<Integer> node, int value) {
	    if (node == null) {
	        return null; 
	    } else if (node.getValue() == value) {
	        return node; 
	    } else if (value < node.getValue()) {
	        return findNodeWithValue(node.getLeft(), value); 
	    } else {
	        return findNodeWithValue(node.getRight(), value); 
	    }
	}
	
	//  function to add head before value
	public static BinNode<Integer> addHead (BinNode<Integer> chain, int num){
		BinNode<Integer> pos = findNodeWithValue(chain, num);
		pos.setRight(chain);
		return pos;
	}
	
	// function to add node after value
	public static BinNode<Integer> addAfter (BinNode<Integer> chain, int num, BinNode<Integer> after){
		BinNode<Integer> pos = findNodeWithValue(chain, num);
		pos.setRight(after);
		return chain;
	}
	
	// function to add node before value
	public static BinNode<Integer> addBefore (BinNode<Integer> chain, int num, BinNode<Integer> before){
		BinNode<Integer> pos = findNodeWithValue(chain, num);
		pos.setLeft(before);
		return chain;
	}
	
	// function to print chain from array
	public static void printBinChainForARR (BinNode<Integer> myChain) {
		while(myChain.hasRight())
		{
			System.out.println(myChain.getValue() + "  value");
			if(myChain.hasLeft())
				System.out.println(myChain.getLeft().getValue() + " left");
			if (myChain.hasRight())
				System.out.println(myChain.getRight().getValue() + " right");
			System.out.println("****");
			myChain = myChain.getRight();
		}
	}


	// function to return middle node 
	public static BinNode<Integer> getMiddle(BinNode<Integer> chain) {
		BinNode<Integer> closer = chain;
		BinNode<Integer> longer = chain;

		    while (longer != null && longer.getRight() != null) {
		    	longer = longer.getRight().getRight();  // two steps
		        closer = closer.getRight();				// one step
		    }
		    return closer;
	}
		
}



