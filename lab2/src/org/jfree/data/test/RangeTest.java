package org.jfree.data.test;


import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

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

public void testCentralValueShouldBeZero() {

assertEquals("The central value of -1 and 1 should be 0",

0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);

}
@Test

public void testCombine() {
	assertEquals("combine:should return expected output",Range.combine(Range1,Range2).getCentralValue(),new Range(-1,0).getCentralValue(),0.000000001d);
			}


@Test

public void testConstrain() {
	Range1.constrain(1);
	assertEquals("constrain:should return expected output",Range1.toString(),new Range(0,2).toString());
}
@Test
public void testContains() {
	assertTrue("Contains:should return expected output",Range1.contains(1));
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
public void testGetCentralValue() {
assertEquals("GetCentralValue:should return expected output",Range1.getCentralValue(),1.0, 0.000000001d);

}
@Test
public void testGetLength() {
assertEquals("GetLength:should return expected output",Range1.getLength(),2.0, 0.000000001d);

}
@Test
public void testGetLowerBound() {
assertEquals("GetLowerBound:should return expected output",Range1.getLowerBound(),0.0, 0.000000001d);

}
@Test
public void testGetUpperBound() {
assertEquals("GetUpperBound:should return expected output",Range1.getUpperBound(),0.0, 0.000000001d);

}
@Test
public void testExpandToInclude() {
	Range Range3=Range.expandToInclude(Range2,1);
	assertTrue("ExpandToInclude:should return expected output",Range3.equals(new Range(-1,1)));
}
@Test
public void testIntersects() {
assertTrue("Intersects:should return expected output",Range1.intersects(0,4));

}
@Test
public void testHashCode() {
	Range Range3=new Range(0,1);
assertNotSame("HashCode:should return expected output",Range3.hashCode(),Range3.hashCode());

}
@Test
public void testShift() {
	Range Range3=new Range(0,1);
assertEquals("Shift:should return expected output",Range.shift(Range3,2),new Range(2,2));

}

@Test
public void testShift2() {
	Range Range3=new Range(0,1);
assertEquals("Shift2:should return expected output",Range.shift(Range3,2,true),new Range(2,2));

}
@Test
public void testToString() {
	Range Range3=new Range(0,1);
assertEquals("ToString:should return expected output",Range3.toString(),"Range[0.5,1.0]");

}

}



