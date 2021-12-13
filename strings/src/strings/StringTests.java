package strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringTests {
	private static final int N_STRINGS = 2000;
	final String str = "Hello";
	final StringBuilder strBuilder = new StringBuilder("Hello");
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void replaceTest() {
		
		assertEquals("*ello", str.replace("H", "*"));
		strBuilder.replace(0, 1, "**");
		assertEquals( "**ello", strBuilder.toString());
	}
	private String joinString(String[]strings,String delimiter) {
		String res =strings[0];
		for(int i=1;i<strings.length;i++) {
			res+=delimiter+strings[i];
		}
		return res;
	}
	private String joinStringBuilder(String[]strings,String delimiter) {
		StringBuilder res =new StringBuilder(strings[0]);
		for(int i=1;i<strings.length;i++) {
			res.append(delimiter).append(strings[i]);
		}
		return res.toString();
	}
	private String[] getStrings(int nStrings) {
		String[] res= new String[nStrings];
		for(int i=0;i<nStrings;i++) {
			res[i]=str;
		}
		return res;
	}
	
//	@Test
//	void functionalJoinStringTest() {
//		String expected = str+";"+str;
//		assertEquals(expected, joinString(getStrings(2), ";"));
//	}
	@Test
	void functionalJoinStringBuilderTest() {
		String expected = str+";"+str;
		assertEquals(expected, joinStringBuilder(getStrings(2), ";"));
	}
	@Test
	void performanceJoinStringTest() {
		joinString(getStrings(N_STRINGS), ";");
	}
	@Test
	void performanceJoinStringBuilderTest() {
		joinStringBuilder(getStrings(N_STRINGS), ";");
	}
}
