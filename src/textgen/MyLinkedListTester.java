/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		String erased = shortList.remove(1); // B
		assertEquals("Remove: check index 1 ('B') is correct ", "B", erased);
		assertEquals("Remove: check shortList element 0 is correct ", "A", shortList.get(0));
		assertEquals("Remove: check shortList size is correct ", 1, shortList.size());
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		// Test a not empty list
		assertEquals("AddEnd: check 'C' returns true in not-empty list", true, shortList.add("C"));
		assertEquals("AddEnd: check 'C' has correct index", "C", shortList.get(2));
		// test an empty list
		MyLinkedList<Integer> anEmptyList = new MyLinkedList<Integer>();
		assertEquals("AddEnd: check first element into emptyList", true, anEmptyList.add(Integer.valueOf(1)));
		assertEquals("AddEnd: check first element has correct index", Integer.valueOf(1), anEmptyList.get(0));
		// test for null element
		try {
			shortList.add(null);
			fail("AddEnd: null element shuold not be added");
		}
		catch(NullPointerException e) {
		}
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		// test not-empty list
		assertEquals("Size: check the size of not-empty list", 2, shortList.size());
		// test empty list
		assertEquals("Size: check the size of not-empty list", 0, emptyList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		// Test a not-empty list at the end
		shortList.add(2, "D");
		assertEquals("AddAtIndex: check 'D' at the end in not-empty list", "D", shortList.get(2));
		// test a not-empty list middle
		shortList.add(2, "C");
		assertEquals("AddAtIndex: check 'C' has correct index in middle not-empty list", "C", shortList.get(2));
		assertEquals("AddAtIndex: check element moved toward end index inserting middle not-empty list", "D", shortList.get(3));
		// test a not-empty list at its start
		shortList.add(0, "0");
		assertEquals("AddAtIndex: check '0' has correct index at start not-empty list", "0", shortList.get(0));
		assertEquals("AddAtIndex: check element moved toward end index inserting middle not-empty list", "D", shortList.get(4));
		// test an empty list
		MyLinkedList<Integer> anEmptyList = new MyLinkedList<Integer>();
		anEmptyList.add(0, Integer.valueOf(1));
		assertEquals("AddAtIndex: check first element has correct index", Integer.valueOf(1), anEmptyList.get(0));
		// test for invalid index
		try {
			shortList.add(-1, "-1");
			fail("AddAtIndex: to index -1 element should not be added");
		}
			catch(IndexOutOfBoundsException e) {
		}
		try {
			shortList.add(25, "25");
			fail("AddAtIndex: to index > size element should not be added");
		}
			catch(IndexOutOfBoundsException e) {
		}
		// test for null element
		try {
			shortList.add(null);
			fail("AddAtIndex: null element shuold not be added");
		}
			catch(NullPointerException e) {
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		// test set E at i=0
		assertEquals("Check returned value after set at i:0", Integer.valueOf(0), longerList.set(0, -1));
		assertEquals("Check new value after set at i:0", Integer.valueOf(-1), longerList.get(0));
		// test set E at last
		assertEquals("Check returned value after set at i:last", Integer.valueOf(9), longerList.set(longerList.size()-1, -1));
		assertEquals("Check new value after set at i:last", Integer.valueOf(-1), longerList.get(longerList.size()-1));
		// test set E at middle
		assertEquals("Check returned value after set at i:3", Integer.valueOf(3), longerList.set(3, -1));
		assertEquals("Check new value after set at i:3", Integer.valueOf(-1), longerList.get(3));
	    // test for invalid index
		try {
			longerList.set(25, 25);
			fail("Set: to index > size element should not be added");
		}
			catch(IndexOutOfBoundsException e) {
		}
		try {
			longerList.set(-1, 25);
			fail("Set: to negative index element should not be added");
		}
			catch(IndexOutOfBoundsException e) {
		}
		// test for null element
		try {
			longerList.set(1, null);
			fail("Set: null element shuold not be added");
		}
			catch(NullPointerException e) {
		}
	}
	
	
	// TODO: Optionally add more test methods.
	
}
