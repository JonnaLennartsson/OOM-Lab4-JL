package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToString() {
		String testString = "1991-09-10 11:00"; 
		
		DateTime jonnasDayOfBirth = new DateTime(1991,9,10,11,0);
		
	
		assertEquals("Fail, not equals", testString, jonnasDayOfBirth.toString());
	}

	@Test
	public void testDateTimeString() {
		String testString = "1991-09-10 11:00"; 
		
		DateTime jonnasDayOfBirth = new DateTime(testString);
		
		assertEquals("Fail, not equals", testString, jonnasDayOfBirth.toString());
	}

}
