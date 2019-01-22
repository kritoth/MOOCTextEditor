package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode(null);
		tail = new LLNode(null);
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) throws NullPointerException 
	{
		// TODO: Implement this method
		if(element != null) {
			LLNode<E> newNode = new LLNode(element);
			if(head.next != null && tail.prev != null) {
				newNode.next = tail.prev.next;
				tail.prev.next = newNode;
				tail.prev = newNode;
				size++;
				return true;
			}
			else {
				head.next = newNode;
				newNode.prev = head;
				newNode.next = tail;
				tail.prev = newNode;
				size++;
				return true;
			}
		}
		else {
			throw new NullPointerException();
		}
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method.
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else if(index >= size) {
			throw new IndexOutOfBoundsException();
		}
		else{
			LLNode<E> result = head;
			LLNode<E> currNode = head.next;
			int counter = 0;
			while(counter <= index) {
				result = currNode;
				currNode = result.next;
				counter++;
			}
			return (E) result.data;
		}
		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
