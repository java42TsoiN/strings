package strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestsClassString {
	final String string = "Hello World";

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void testCharAt() {
		assertEquals('e', string.charAt(1));
		try {
			string.charAt(12);
			fail("IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {

		}
	}

	@Test
	void testEqualsIgnoreCase() {
		assertTrue(string.equalsIgnoreCase("hello world"));
		assertTrue(string.equalsIgnoreCase("HEllo world"));
	}

	@Test
	void testCompareToIgnoreCase() {
		assertEquals(0, string.compareToIgnoreCase("hello world"));
		assertEquals(-3, string.compareToIgnoreCase("Hello worldddd"));
		assertEquals(2, string.compareToIgnoreCase("Hello wor"));
	}

	@Test
	void testStartsWithStringInt() {
		assertTrue(string.startsWith("or", 7));
		assertFalse(string.startsWith("world", 4));
	}

	@Test
	void testStartsWithString() {
		assertTrue(string.startsWith("Hell"));
		assertFalse(string.startsWith("world"));
	}

	@Test
	void testEndsWith() {
		assertTrue(string.endsWith("orld"));
		assertFalse(string.startsWith("world"));
	}

	@Test
	void testIndexOfInt() {
		assertEquals(6, string.indexOf('W'));
		assertEquals(-1, string.indexOf('w'));
	}

	@Test
	void testIndexOfIntInt() {
		assertEquals(7, string.indexOf('o', 5));
		assertEquals(-1, string.indexOf('o', 8));
	}

	@Test
	void testLastIndexOfIntInt() {
		assertEquals(4, string.lastIndexOf('o', 5));
		assertEquals(-1, string.lastIndexOf('o', 3));
	}

	@Test
	void testIndexOfString() {
		assertEquals(5, string.indexOf(" Wor"));
		assertEquals(-1, string.indexOf("wor"));
	}

	@Test
	void testIndexOfStringInt() {
		assertEquals(4, string.indexOf("o", 3));
		assertEquals(-1, string.indexOf("wor", 4));
	}

	@Test
	void testLastIndexOfString() {
		assertEquals(7, string.lastIndexOf("o"));
		assertEquals(-1, string.lastIndexOf("wor"));
	}

	@Test
	void testSubstringInt() {
		assertEquals("o World", string.substring(4));
		try {
			string.substring(12);
			fail("IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {

		}
	}

	@Test
	void testSubstringIntInt() {
		assertEquals("o W", string.substring(4, 7));
		try {
			string.substring(4, 12);
			fail("IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {

		}
	}

	@Test
	void testContains() {
		assertTrue(string.contains("Wor"));
		assertFalse(string.contains("wor"));
	}

	@Test
	void testJoinCharSequenceCharSequenceArray() {
		String expected = "Happy-New-Year!";
		assertEquals(expected, string.join("-", "Happy", "New", "Year!"));
	}

	@Test
	void testToLowerCase() {
		String expected = "hello world";
		assertEquals(expected, string.toLowerCase());
	}

	@Test
	void testTrim() {
		String str1 = " Hello world! ";
		String expected = "Hello world!";
		assertEquals(expected, str1.trim());
	}

	@Test
	void testToCharArray() {
		String actual = "Hello!";
		char[] expected = { 'H', 'e', 'l', 'l', 'o', '!' };
		assertArrayEquals(expected, actual.toCharArray());
	}

	@Test
	void testFormatStringObjectArray() {
		String str1 = "Happy year!";
		String expected = "Happy new year!";
		assertEquals(expected, str1.format("Happy %s year!", "new"));
	}

}
