package strings;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestsClassStringBuilder {
	StringBuilder str;
	@BeforeEach
	void setUp() throws Exception {
		str = new StringBuilder("Hello world");
	}
	@Test
	void testAppendString() {
		String expected = "Hello world!!!";
		str.append("!!!");
		assertEquals(expected, str.toString());
	}

	@Test
	void testReplaceIntIntString() {
		String expected = "Hello Java";
		str.replace(6,11,"Java");
		assertEquals(expected, str.toString());
	}

	@Test
	void testInsertIntString() {
		String expected = "Hello wonderful world";
		str.insert(6,"wonderful ");
		assertEquals(expected, str.toString());
	}

	@Test
	void testReverse() {
		String expected = "dlrow olleH";
		str.reverse();
		assertEquals(expected, str.toString());
	}

}
