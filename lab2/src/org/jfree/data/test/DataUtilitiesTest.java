package org.jfree.data.test;
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
public class DataUtilitiesTest {
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
    testValues1.addValue(1, 0, 0);
    testValues1.addValue(4, 1, 0);
  }
  @After
  public void tearDown() {
    values2D = null;
  }

  @Test
  public void testNullGetCumulativePercentages() {
	 {
		 KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyedValues);
	assertEquals("wrong percentage return. It should be 1.4545454545454546", 1.4545454545454546, 
    		(double)cumulativePercentages.getValue("2"),  0.0000001d);
	  } 
	}
  @Test
  public void testNullCreateNumberArray2D() {
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
  public void testNullCreateNumberArray() {
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
  public void testValidDataAndRowTotal() {
    assertEquals("Wrong sum returned. It should be 0.0", 0.0,
        DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
    
  }
  @Test
  public void testValidDataAndColumnColumnTotal() {
    assertEquals("Wrong sum returned. It should be 6.0", 6.0,
        DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
  }
  @Test
  public void testValidDataAndColumnColumnTotal1() {
    assertEquals("Wrong sum returned. It should be 5.0", 5.0,
        DataUtilities.calculateColumnTotal(values2D1, 0), 0.0000001d);
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
}
