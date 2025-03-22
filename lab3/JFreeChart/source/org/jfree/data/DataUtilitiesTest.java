package org.jfree.data;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
public class DataUtilitiesTest extends DataUtilities{
  private Values2D values2D;
  private Values2D values2D1;
  private DefaultKeyedValues keyedValues;
  @Before
  public void setUp() {
	  keyedValues=new DefaultKeyedValues();
	  keyedValues.addValue("0",5);
	  keyedValues.addValue("1",9);
	  keyedValues.addValue("2",2);
    DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
    values2D = testValues;
    testValues.addValue(2, 0, 0);
    testValues.addValue(4, 1, 0);
    DefaultKeyedValues2D testValues1 = new DefaultKeyedValues2D();
    values2D1 = testValues1;
    testValues1.addValue(1, 1, 1);
    testValues1.addValue(4, 1, 0);
  }
  @After
  public void tearDown() {
    values2D = null;
  }

  @Test
  public void testNullGetCumulativePercentages1normalvalue() {
	 {
		 KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyedValues);
	assertEquals("wrong percentage return. It should be 0.9", 0.9, 
    		(double)cumulativePercentages.getValue("2"),  0.0000001d);
	  } 
	}
  @Test
  public void testNullGetCumulativePercentages() {
	 
		 try {
			    DataUtilities.getCumulativePercentages(null);
			    fail("No exception thrown. The expected outcome was: a thrown exception of "
			         + "type: IllegalArgumentException");
			  } catch (Exception e) {
			    assertTrue("Incorrect exception type thrown",
			        e.getClass().equals(IllegalArgumentException.class));
			  }
			
	}
  @Test
  public void testNullGetCumulativePercentages2specialvalue() {
	  {
		  keyedValues.addValue("3" ,Double.NaN);
			 KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyedValues);
		assertEquals("wrong percentage return. It should be 1.4545454545454546", Double.NaN, 
	    		(double)cumulativePercentages.getValue("3"),  0.0000001d);
		  } 
  }
  @Test
  public void testNullCreateNumberArray1invalidvalue() {
	  try {
	    DataUtilities.createNumberArray(null);
	    fail("No exception thrown. The expected outcome was: a thrown exception of "
	         + "type: IllegalArgumentException");
	  } catch (Exception e) {
	    assertTrue("Incorrect exception type thrown",
	        e.getClass().equals(IllegalArgumentException.class));
	  }
	}
  @Test
  public void testNullCreateNumberArray2negativevalue() {
		double[] test2 = {-1.0};
		  Number[] result=DataUtilities.createNumberArray(test2);
		  assertEquals(1, result.length);
		  }
  @Test
  public void testCreateNumberArray3PositiveNumbers() {
      double[] test = {1.0, 2.5, 3.0};
      Number[] result = DataUtilities.createNumberArray(test);
      assertEquals(3, result.length);
      assertEquals(2.5, result[1].doubleValue(), 0.000001);
  }
  @Test
  public void testCreateNumberArray4SpecialValues() {
      double[] test = {Double.NaN, Double.POSITIVE_INFINITY,0};
      Number[] result = DataUtilities.createNumberArray(test);
      assertEquals(3, result.length);
      assertTrue(Double.isNaN(result[0].doubleValue()));  
      assertEquals(Double.POSITIVE_INFINITY, result[1].doubleValue(), 0.000001);
  }
  @Test
  public void testNullCreateNumberArray2D1invalidvalue() {
	  try {
	    DataUtilities.createNumberArray2D(null);
	    fail("No exception thrown. The expected outcome was: a thrown exception of "
	         + "type: IllegalArgumentException");
	  } catch (Exception e) {
	    assertTrue("Incorrect exception type thrown",
	        e.getClass().equals(IllegalArgumentException.class));
	  }
	}
  @Test
  public void testNullCreateNumberArray2D2negativevalue() {
		double[][] test2 = {{-1.0}};
		  Number[][] result=DataUtilities.createNumberArray2D(test2);
		 
		  assertEquals(1, result.length);
		  }
  @Test
  public void testCreateNumberArray2D3PositiveNumbers() {
      double[][] test = {{1.0, 2.5, 3.0}};
      Number[][] result = DataUtilities.createNumberArray2D(test);
      System.out.println(result);
      assertEquals(1, result.length);
      assertEquals(2.5, result[0][1].doubleValue(), 0.000001);
  }
//  @Test
//  public void testCreateNumberArray2D3PositiveNumbers() {
//      double[][] test = {{1.0, 2.5, 3.0}};
//      Number[][] result = DataUtilities.createNumberArray2D(test);
//      System.out.println(result);
//      assertEquals(result[0][2], 0);
//      assertEquals(2.5, result[0][1].doubleValue(), 0.000001);
//  }
  @Test
  public void testCreateNumberArray2D4SpecialValues() {
      double[][] test ={{Double.NaN, Double.POSITIVE_INFINITY,0}};
      Number[][]result = DataUtilities.createNumberArray2D(test);
      assertEquals(1, result.length);
      assertTrue(Double.isNaN(result[0][0].doubleValue()));  
      assertEquals(Double.POSITIVE_INFINITY, result[0][1].doubleValue(), 0.000001);
  }
  @Test
  public void testValidDataAndRowTotal() {
    assertEquals("Wrong sum returned. It should be 2.0", 2.0,
        DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
    
  }
  @Test
  public void testValidDataAndRowTotalNull() {
	  DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
	    values2D1 = testValues;
	    testValues.addValue(2, 0, 0);
	    testValues.addValue(4, 1, 0);
	    testValues.addValue(null, 1, 1);
    assertEquals("Wrong sum returned. It should be 2.0", 2.0,
        DataUtilities.calculateRowTotal(values2D1, 0), 0.0000001d);
    
  }
  @Test
  public void testValidDataAndRowTotal1Negativevalue() {
			 try 
			 { 
				 DataUtilities.calculateRowTotal(values2D1, -1); 
			  fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
			 } 
			 catch (Exception e) 
			 { 
			  assertTrue("Incorrect exception type thrown",  
			   e.getClass().equals(IndexOutOfBoundsException.class)); 
			 } 
  }
  
  @Test
  public void testValidDataAndRowTotal2bordercaseleft() {
    assertEquals("Wrong sum returned. It should be 5.0", 5.0,
        DataUtilities.calculateRowTotal(values2D1, 0), 0.0000001d);
  }
  @Test
  public void testValidDataAndRowTotal3borfercaseright() {
	  try 
		 { 
			 DataUtilities.calculateRowTotal(values2D1, 2147483647); 
		  fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
		 } 
		 catch (Exception e) 
		 { 
		  assertTrue("Incorrect exception type thrown",  
		   e.getClass().equals(IndexOutOfBoundsException.class)); 
		 } 
  }
 
  @Test
  public void testValidDataAndColumnTotal11Negativevalue() {
			 try 
			 { 
				 DataUtilities.calculateColumnTotal(values2D1, -1); 
			  fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
			 } 
			 catch (Exception e) 
			 { 
			  assertTrue("Incorrect exception type thrown",  
			   e.getClass().equals(IndexOutOfBoundsException.class)); 
			 } 
  }
  @Test
  public void testValidDataAndColumnTotal1NULL() {
	  DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
	    values2D = testValues;
	    testValues.addValue(2, 1, 0);
	    testValues.addValue(4, 2, 0);
	    testValues.addValue(null, 3, 0);
 double A=DataUtilities.calculateColumnTotal(values2D, 0);
 assertEquals(A,6.0,0.0000001d);
  }

  @Test
  public void testGetCumulativePercentages_AllValuesAreNull() {
      DefaultKeyedValues data = new DefaultKeyedValues();
      data.addValue("A", null);
      data.addValue("B", null);
      data.addValue("C", null);

      KeyedValues result = DataUtilities.getCumulativePercentages(data);

      assertEquals(3, result.getItemCount());
      assertEquals(result.getValue(0),Double.NaN);
      assertEquals(result.getValue(1),Double.NaN);
      assertEquals(result.getValue(2),Double.NaN);
  }
  @Test
  public void testValidDataAndColumnTotal12bordercaseleft() {
    assertEquals("Wrong sum returned. It should be 1.0", 1.0,
        DataUtilities.calculateColumnTotal(values2D1, 0), 0.0000001d);
  }
  @Test
  public void testValidDataAndColumnTotal13borfercaseright() {
	  try 
		 { 
			 DataUtilities.calculateColumnTotal(values2D1, 2147483647); 
		  fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
		 } 
		 catch (Exception e) 
		 { 
		  assertTrue("Incorrect exception type thrown",  
		   e.getClass().equals(IndexOutOfBoundsException.class)); 
		 } 
  }
  @Test
  public void testValidDataAndColumnTotal14insidetherange() {
    assertEquals("Wrong sum returned. It should be 4.0", 4.0,
        DataUtilities.calculateColumnTotal(values2D1, 1), 0.0000001d);
  }
  @Test
  public void testNullDataColumnTotal() {
	  try {
	    DataUtilities.calculateColumnTotal(null, 0);
	    fail("No exception thrown. The expected outcome was: a thrown exception of "
	         + "type: IllegalArgumentException");
	  } catch (Exception e) {
	    assertTrue("Incorrect exception type thrown",
	        e.getClass().equals(NullPointerException.class));
	  }
	}
//  public void testNullDataColumnTotal() {
//	  try {
//	    DataUtilities.calculateColumnTotal(null, 0);
//	    fail("No exception thrown. The expected outcome was: a thrown exception of "
//	         + "type: IllegalArgumentException");
//	  } catch (Exception e) {
//	    assertTrue("Incorrect exception type thrown",
//	        e.getClass().equals(IllegalArgumentException.class));
//	  }
//	}
}
