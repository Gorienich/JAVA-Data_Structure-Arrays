package stack;

public class Node<T> {

	private T value;        //The node's value
	private Node<T> next;   //The node's next
	
	//constructor
	public Node(T x)
    {
        this.value = x;
        this.next = null;
    }
	
	//constructor 
	public Node(T x,Node<T> next)
    {
        this.value = x;
        this.next = next;
    }
	
	//returns the node value
	public T getValue()
	{
		
		return value;
    }

	//return the node next reference
	public Node<T> getNext()
	{
		return next;
	}
	
	//return true if the node has a next reference
	public boolean hasNext()
	{
		return (next != null);
	}
	
	//returns the node state as a string
	public String toString()
	{
		return "" + value; 
	}
	
	//set the node's value to x
	public void setValue(T x)
	{
		this.value = x;
	}
	
	//set the node's next value to next
	public void setNext(Node<T> next)
	{
		this.next = next;
	}
}