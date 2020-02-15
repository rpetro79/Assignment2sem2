package BlockingQueueAdapter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    private ListADT<String> list;

    @Before
    public void setup()
    {
        list = new ArrayList<String>();
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddIndexNegative()
    {
        list.add(-1, "1");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddIndexBiggerThanSize()
    {
        list.add(1, "1");
    }

    @Test
    public void testAddCorrectIndex()
    {
        list.add(0, "1");
    }

    @Test
    public void testAddingAndSize()
    {
        list.add("1");
        assertTrue(list.get(0).equals("1"));
        assertTrue(list.size() == 1);
    }

    @Test
    public void testGet()
    {
        list.add("1");
        assertTrue(list.get(0).equals("1"));
    }

    @Test (expected = IllegalStateException.class)
    public void testGetIndexNegative()
    {
        list.add("1");
        list.get(-1);
    }

    @Test (expected = IllegalStateException.class)
    public void testGetIndexTooBig()
    {
        list.add("1");
        list.get(2);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetIndexNegative()
    {
        list.add("1");
        list.add("2");
        list.add("3");
        list.set(-1, "1");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetIndexTooBig()
    {
        list.add("1");
        list.add("2");
        list.add("3");
        list.set(3, "1");
    }

    @Test
    public void testSet()
    {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        list.set(3, "0");
        assertTrue(list.get(3).equals("0"));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveNegativeIndex()
    {
        list.remove(-1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexTooBig()
    {
        list.add("a");
        list.remove(1);
    }

    @Test
    public void testRemove()
    {
        list.add("a");
        list.remove(0);
        assertTrue(list.size() == 0);
    }

    @Test
    public void TestIndexOf()
    {
        list.add("a");
        list.add("b");
        list.add("a");
        assertTrue(list.indexOf("a") == 0);
        assertTrue(list.indexOf("b") == 1);
        list.remove(0);
        assertTrue(list.indexOf("a") == 1);

        assertTrue(list.indexOf("c") == -1);
        assertTrue(list.indexOf(null) == -1);
    }

    @Test
    public void testRemoveElement()
    {
        list.add("a");
        list.add("b");
        list.add("a");
        list.remove("a");
        assertTrue(list.get(0).equals("b"));
        assertTrue(list.get(1).equals("a"));
    }

    @Test (expected = IllegalStateException.class)
    public void testRemoveElementNotInArray()
    {
        list.add("a");
        list.add("b");
        list.add("a");
        list.remove("c");
    }

    @Test
    public void testContains()
    {
        list.add("a");
        list.add("b");
        list.add("a");
        assertTrue(list.contains("a"));
        assertFalse(list.contains("c"));
        assertFalse(list.contains(null));
    }

    @Test
    public void testIsEmpty()
    {
        assertTrue(list.isEmpty());
        list.add("1");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testIsFull()
    {
        assertFalse(list.isFull());
    }

    @Test
    public void testToString()
    {
        list.add("1");
        list.add("1");
        list.add("1");
        assertTrue(list.toString().equals("{1, 1, 1}"));
    }

    @Test
    public void testExpand(){
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        assertTrue(list.size() == 110);
    }
}