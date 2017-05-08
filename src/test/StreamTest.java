package test;

import static org.junit.Assert.*; 

import org.junit.Test;

import main.Main;
import main.Stream;
import main.StreamImpl;

public class StreamTest {

	@Test
	public void nullTextTest() {
		// Arrange
		Stream stream = new StreamImpl(null);
		//test
		assertEquals("hasNext() with null text must return false", false, stream.hasNext());
	}

	@Test
	public void emptyTextTest() {
		// Arrange
		Stream stream = new StreamImpl("");
		//test
		assertEquals("hasNext() with empty text must return false", false, stream.hasNext());
	}
	
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void indexOutOfBoundsExceptionTest() {
		// Arrange
		Stream stream = new StreamImpl(null);
		//test
		assertTrue(stream.getNext() != 0);
	}
	
	@Test()
	public void firstCharWasFoundTest() {
		// Arrange
		Stream stream = new StreamImpl("aAbBABacafe");
		char expected = Main.firstChar(stream);
		//test
		assertEquals("firstChar must be e", 'e', expected);
	}
	
	@Test()
	public void firstCharWasNotFoundTest() {
		// Arrange
		Stream stream = new StreamImpl("AAAaaaAAaa");
		char expected = Main.firstChar(stream);
		//test
		assertEquals("firstChar must be 0", 0, expected);
	}
}
