package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {	
		
	}

	@Test
	public void testShiftTimeZone() {
		
		DateTime myTime = new DateTime(2018, 10, 3, 10, 17);
		DateTime test1 = new DateTime(0, 0, 0, 0, 0);
		int frmOffset = 1;
		int tOffset = 9;
		
		
		test1 = TimeZoneTranslator.shiftTimeZone(myTime, frmOffset, tOffset);	
		assertEquals("Fail, not equals", "2018-10-03 18:17", test1.toString());
		
	}

	@Test
	public void testShiftEventTimeZone() {
		
		DateTime startTime = new DateTime(2018,12,31,00,00);
		DateTime endTime = new DateTime(2018,12,31,23,59);
		Person jonna = new Person("Jonna Lennartsson");
		Person joel = new Person("Joel olofsson");
		Place jonkoping = new Place("Jönköping", 57.7559194,14.047828,11.00);
		
		Event newYearsEve = new Event("new Years Eve",
				startTime,
				endTime,
				new HashSet<>(Arrays.asList(jonna, joel)),
				jonkoping);
		
		System.out.println(String.format("============\nOriginal event\n============\n%s", newYearsEve.toString()));

		newYearsEve = TimeZoneTranslator.shiftEventTimeZone(newYearsEve, TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.JAPAN);

		
		Event thisIsExpected = new Event("new Years Eve", 
				new DateTime(2018,12,31,8,00),
				new DateTime(2019, 1, 1, 7, 59),
				new HashSet<>(Arrays.asList(jonna, joel)),
				jonkoping);
		
		
		System.out.println();
		System.out.println(String.format("============\nthis is expected\n============\n%s", thisIsExpected.toString()));
		System.out.println();
		System.out.println(String.format("============\nwhat I got\n============\n%s", newYearsEve.toString()));
		
		
		assertEquals("Fail, not equals", thisIsExpected.toString() , newYearsEve.toString());
		
		
	}

}
