package strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static strings.RegExpressions.*;
class RegExpressionsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void javaVariableTrue() {
		assertTrue("__".matches(javaVariable()));
		assertTrue("$".matches(javaVariable()));
		assertTrue("a2".matches(javaVariable()));
		assertTrue("_2".matches(javaVariable()));
		assertTrue("A".matches(javaVariable()));
		assertTrue("$$".matches(javaVariable()));
	}
	@Test
	void javaVariableFalse() {
		assertFalse("_".matches(javaVariable()));
		assertFalse("1_".matches(javaVariable()));
		assertFalse("&abc".matches(javaVariable()));
		assertFalse("#".matches(javaVariable()));
	}
	@Test
	void lessEqual300Truetest() {
		assertTrue("1".matches(lessEqual300()));
		assertTrue("99".matches(lessEqual300()));
		assertTrue("299".matches(lessEqual300()));
		assertTrue("100".matches(lessEqual300()));
		assertTrue("300".matches(lessEqual300()));
	}
	@Test
	void lessEqual300Falsetest() {
		assertFalse("0".matches(lessEqual300()));
		assertFalse("09".matches(lessEqual300()));
		assertFalse("301".matches(lessEqual300()));
		assertFalse("310".matches(lessEqual300()));
		assertFalse("#".matches(lessEqual300()));
		assertFalse(" 40".matches(lessEqual300()));
	}
	@Test
	void ipV4TrueTest() {
		assertTrue("0".matches(ipV4Part()));
		assertTrue("001".matches(ipV4Part()));
		assertTrue("255".matches(ipV4Part()));
		assertTrue("020".matches(ipV4Part()));
		assertTrue("199".matches(ipV4Part()));
		assertTrue("10".matches(ipV4Part()));
		assertTrue("100".matches(ipV4Part()));
		assertTrue("99".matches(ipV4Part()));
		assertTrue("000".matches(ipV4Part()));
		assertTrue("226".matches(ipV4Part()));
	}
	@Test
	void ipV4FalseTest() {
		assertFalse("0000".matches(ipV4Part()));
		assertFalse("-10".matches(ipV4Part()));
		assertFalse("#".matches(ipV4Part()));
		assertFalse("256".matches(ipV4Part()));
		assertFalse("300".matches(ipV4Part()));
		assertFalse("260".matches(ipV4Part()));
		assertFalse("1%".matches(ipV4Part()));
	}
	@Test
	void arithmeticExpressionTrueTest() {
		assertTrue("  20".matches(arithmeticExpression()));
		assertTrue("20 +10 *2/100 +4".matches(arithmeticExpression()));
		assertTrue(" 20 +10 *2/100 +4 ".matches(arithmeticExpression()));
	}
	@Test
	void arithmeticExpressionFalseTest() {
		assertFalse(" 20+".matches(arithmeticExpression()));
		assertFalse(" 20+a".matches(arithmeticExpression()));
		assertFalse("10 20".matches(arithmeticExpression()));
		assertFalse(" # * 10".matches(arithmeticExpression()));
		assertFalse(" 20+&".matches(arithmeticExpression()));
		assertFalse(" +20".matches(arithmeticExpression()));
	}

}
