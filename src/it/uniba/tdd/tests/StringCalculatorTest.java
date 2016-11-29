package it.uniba.tdd.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniba.tdd.StringCalculator;
import it.uniba.tdd.StringCalculatorException;

public class StringCalculatorTest {
	StringCalculator sc = new StringCalculator();
	String emptyString = "";
	String arg1String = "1";
	String stringWith2args = "1,2";
	String stringWithMoreArg = "1,2,3,4,5,6";
	String stringWithSlashN = "1\n2,3";
	String stringWithNegativeNumber = "1,2,-1";
	String stringWithOneThousand = "1,2,3,1001,4";
	String stringWithAnotherDelimier = "//;\n1;2";
	String stringWithAnotherDelimierFormat = "//[***]\n1***2***3";
	
	

	@Test
	public void readEmptyStringAndReturnZero() throws StringCalculatorException {
		assertEquals(sc.add(emptyString),0);
	}
	
	@Test
	public void readStringWithArg1AndReturn1() throws StringCalculatorException{
		assertEquals(sc.add(arg1String),1);
	}
	
	@Test
	public void readA2ArgsString1and2 () throws StringCalculatorException{
		assertEquals(sc.add(stringWith2args),3);
	}
	
	@Test
	public void readAMoreArgsStringAndReturn21 () throws StringCalculatorException{
		assertEquals(sc.add(stringWithMoreArg),21);
	}
	
	@Test
	public void readStringWithSlashN () throws StringCalculatorException{
		assertEquals(sc.add(stringWithSlashN),6);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void readStringWithNegativeNumbers () throws StringCalculatorException{
		int a = sc.add(stringWithNegativeNumber);
	}
	
	@Test 
	public void readStringWithOneThousandNumbers () throws StringCalculatorException{
		assertEquals(sc.add(stringWithOneThousand),10);
	}
	
	@Test 
	public void readStringWithAnotherDelimier  () throws StringCalculatorException{
		assertEquals(sc.add(stringWithAnotherDelimier),3);
	}
	

}
