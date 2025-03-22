package org.jfree.data;


import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Range;

import org.junit.*;


public class RangeTest {


private Range rangeObjectUnderTest;

private Range Range1 ;
private Range Range2 ;


@Before

public void setUp() throws Exception {

rangeObjectUnderTest = new Range(-1, 1);
Range1=new Range(0, 2);
Range2=new Range(-1,3);


}


@After

public void tearDown() throws Exception {

}

@Test
public void testNullRange() {
	 
		 try {
			    new Range(3,0);
			    fail("No exception thrown. The expected outcome was: a thrown exception of "
			         + "type: IllegalArgumentException");
			  } catch (Exception e) {
			    assertTrue("Incorrect exception type thrown",
			        e.getClass().equals(IllegalArgumentException.class));
			  }
			
	}

@Test

public void testCentralValueShouldBeZero() {

assertEquals("The central value of -1 and 1 should be 0",

0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);

}
@Test

public void testCombine() {
	assertEquals("combine:should return expected output",Range.combine(Range1,Range2).getCentralValue(),1.0,0.000000001d);
			}

@Test

public void testCombine1() {
	assertEquals("combine:should return expected output",Range.combine(null,Range2).getCentralValue(),1.0,0.000000001d);
			}

@Test

public void testCombine2() {
	assertEquals("combine:should return expected output",Range.combine(Range1,null),null);
			}


@Test

public void testConstrain() {
	Range1.constrain(1);
	assertEquals("constrain:should return expected output",Range1.toString(),new Range(0,2).toString());
}
@Test
public void testConstrain1() {
	Range1.constrain(-1);
	assertEquals("constrain:should return expected output",Range1.toString(),new Range(0,2).toString());
}
@Test
public void testConstrain2() {
	Range1.constrain(3);
	assertEquals("constrain:should return expected output",Range1.toString(),new Range(0,2).toString());
}
@Test
public void testConstrain3() {
	Range1.constrain(0);
	assertEquals("constrain:should return expected output",Range1.toString(),new Range(0,2).toString());
}
@Test

public void testConstrain4() {
	Range1.constrain(2);
	assertEquals("constrain:should return expected output",Range1.toString(),new Range(0,2).toString());
}

@Test
public void testContains1outsiderangeintheleft() {
	assertFalse("Contains:should return expected output",Range1.contains(-6));
}
@Test
public void testContains() {
	assertTrue("Contains:should return expected output",Range1.contains(0));
}
@Test
public void testContains1() {
	assertFalse("Contains:should return expected output",Range1.contains(10));
}

public void testContains2bordercaseleft() {
	assertTrue("Contains:should return expected output",Range1.contains(-1));
}
public void testContains3insidetherange() {
	assertTrue("Contains:should return expected output",Range1.contains(4));
}
public void testContains4borderrangeright() {
	assertTrue("Contains:should return expected output",Range1.contains(8));
}
public void testContains5Outsiderangeintheright() {
	assertTrue("Contains:should return expected output",Range1.contains(13));
}
@Test
public void testEquals() {
	Range Range3=new Range(1,3);
	Range Range4=new Range(1,3);
	assertFalse("Equals:should return expected output",Range1.equals(Range4));
	assertTrue("Equals:should return expected output",Range3.equals(Range4));
}
@Test
public void testExpand() {
	Range Range3=new Range(2,6);
	Range Range4=Range.expand(Range3, 0.25, 0.5);
	assertTrue("Expand:should return expected output",Range4.equals(new Range(1,8)));
}

@Test
public void testExpand1() {
	
	try {
	    Range.expand(null, 0.25, 0.5);
	    fail("No exception thrown. The expected outcome was: a thrown exception of "
	         + "type: IllegalArgumentException");
	  } catch (Exception e) {
	    assertTrue("Incorrect exception type thrown",
	        e.getClass().equals(IllegalArgumentException.class));
	  }

}
@Test
public void testGetCentralValue() {
assertEquals("GetCentralValue:should return expected output",Range1.getCentralValue(),1.0, 0.000000001d);

}
@Test
public void testGetLength() {
assertEquals("GetLength:should return expected output",Range1.getLength(),2.0, 0.000000001d);

}
@Test
public void testGetLowerBoundnormalvalue() {
assertEquals("GetLowerBound:should return expected output",Range1.getLowerBound(),0.0, 0.000000001d);

}
@Test
public void testGetLowerBoundspeicalvalue() {
	 Range Range3=new Range(Integer.MIN_VALUE, Integer.MAX_VALUE);
assertEquals("GetLowerBound:should return expected output",Range3.getLowerBound(),Integer.MIN_VALUE, 0.000000001d);

}
@Test
public void testGetUpperBoundnormalvalue() {
assertEquals("GetUpperBound:should return expected output",Range1.getUpperBound(),2.0, 0.000000001d);

}
@Test
public void testGetUpperBoundspecialvalue() {
	 Range Range3=new Range(Integer.MIN_VALUE, Integer.MAX_VALUE);
assertEquals("GetUpperBound:should return expected output",Range3.getUpperBound(),Integer.MAX_VALUE, 0.000000001d);

}

@Test
public void testExpandToInclude() {
	Range Range3=Range.expandToInclude(Range2,1);
	assertTrue("ExpandToInclude:should return expected output",Range3.equals(new Range(-1,1)));
}
@Test
public void testExpandToInclude1() {
	Range Range3=Range.expandToInclude(null,1);
	assertTrue("ExpandToInclude:should return expected output",Range3.equals(new Range(1,1)));
}
@Test
public void testExpandToInclude2() {
	Range Range3=Range.expandToInclude(Range2,4);
	assertTrue("ExpandToInclude:should return expected output",Range3.equals(new Range(-1,1)));
}
@Test
public void testExpandToInclude3() {
	Range Range3=Range.expandToInclude(Range2,-2);
	
	assertTrue("ExpandToInclude:should return expected output",Range3.equals(new Range(-2,3)));
}

@Test
public void testIntersects() {
assertTrue("Intersects:should return expected output",Range1.intersects(0,4));

}
@Test
public void testIntersects1() {
assertFalse("Intersects:should return expected output",Range1.intersects(1,-1.5));

}
@Test
public void testIntersects2() {
assertFalse("Intersects:should return expected output",Range1.intersects(0,-4));

}
@Test
public void testIntersects3() {
assertTrue("Intersects:should return expected output",Range1.intersects(1,1.5));

}
@Test
public void testIntersects4() {
assertFalse("Intersects:should return expected output",Range1.intersects(4,3));

}
@Test
public void testHashCodenormalvalue() {
	Range Range3=new Range(0,1);
assertNotSame("HashCode:should return expected output",Range3.hashCode(),Range3.hashCode());

}
public void testHashCodespecialvalue() {
	Range Range3=new Range(Integer.MIN_VALUE, Integer.MAX_VALUE);
assertNotSame("HashCode:should return expected output",Range3.hashCode(),Range3.hashCode());

}
@Test
public void testShift() {
	Range Range3=new Range(0,1);
assertEquals("Shift:should return expected output",Range.shift(Range3,2),new Range(2,2));

}
@Test
public void testShift1() {
	Range Range3=new Range(-2,1);
assertEquals("Shift:should return expected output",Range.shift(Range3,2),new Range(0,3));

}

@Test
public void testShift2() {
	Range Range3=new Range(0,1);
assertEquals("Shift2:should return expected output",Range.shift(Range3,2,true),new Range(2,2));

}
@Test
public void testToStringnormalvalue() {
	Range Range3=new Range(0,1);
assertEquals("ToString:should return expected output",Range3.toString(),"Range[0.0,1.0]");

}
@Test
public void testToStringspecialvalue() {
	Range Range3=new Range(Integer.MIN_VALUE, Integer.MAX_VALUE);
assertEquals("ToString:should return expected output",Range3.toString(),"Range[-2.147483648E9,2.147483647E9]");

}
@Test
public void testEqualNull() {
	
assertFalse("ToString:should return expected output",Range2.equals(null));

}
}



