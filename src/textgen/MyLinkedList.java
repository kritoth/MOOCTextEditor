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
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
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
			LLNode<E> newNode = new LLNode<E>(element);
			if(head.next != null && tail.prev != null) {
				tail.prev.next = newNode;
				newNode.next = tail;
				newNode.prev = tail.prev;			
				tail.prev = newNode;
				size++;
				return true;
			}
			else {				
				newNode.prev = head;
				newNode.next = tail;
				head.next = newNode;
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
			
			return (E) getNode(index).data;
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else if(index > size) {
			throw new IndexOutOfBoundsException();
		}
		else if(index == size) {
			add(element);
		}
		else if(element != null) {
			LLNode<E> newNode = new LLNode<E>(element);
			LLNode<E> currNode = getNode(index);
			LLNode<E> prevNode = currNode.prev;
			
			newNode.next = currNode;
			newNode.prev = prevNode;
			currNode.prev = newNode;
			prevNode.next = newNode;
			size++;	
		}
		else {
			throw new NullPointerException();
		}
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
	public E remove(int index) throws IndexOutOfBoundsException 
	{
		// TODO: Implement this method
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else if(index > size) {
			throw new IndexOutOfBoundsException();
		}
		else {
			LLNode<E> removed = getNode(index);
			LLNode<E> prevNode = removed.prev;
			LLNode<E> nextNode = removed.next;
			
			prevNode.next = removed.next;
			nextNode.prev = removed.prev;
			E data = removed.data;
			removed = null;
			size--;
			return data;
		}
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else if(index >= size) {
			throw new IndexOutOfBoundsException();
		}
		else if(element != null) {
			LLNode<E> currNode = getNode(index);
			E oldData = currNode.data;
			currNode.data = element;
			return oldData;
		}
		else {
			throw new NullPointerException();
		}
	}   
	
	private LLNode<E> getNode(int index){
		LLNode<E> result = head;
		LLNode<E> currNode = head.next;
		int counter = 0;
		while(counter <= index) {
			result = currNode;
			currNode = result.next;
			counter++;
		}
		return result;
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
