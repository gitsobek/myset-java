import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberSetTest {

    @Test
    public void add_IsPutInArray_true() {
        NumberSet mySet = new NumberSet();
        mySet.add(6);
        mySet.add(-4);
        mySet.add(2);
        mySet.add(10);
        mySet.add(8);
        mySet.add(4);
        mySet.add(5);
        mySet.add(2);
        assertTrue(true == mySet.contains(4));
        assertTrue(true == mySet.contains(10));
    }

    @Test
    public void add_IsPutInArray_false() {
        NumberSet mySet = new NumberSet();
        mySet.add(6);
        mySet.add(-4);
        mySet.add(2);
        mySet.add(10);
        mySet.add(8);
        mySet.add(4);
        mySet.add(5);
        mySet.add(2);
        assertFalse(true == mySet.contains(54));
        assertFalse(true == mySet.contains(-20));
    }

    @Test
    public void add_CompareWithSet_true() {
        Set<Integer> set = new HashSet<Integer>();
        set.add(6);
        set.add(-4);
        set.add(2);
        set.add(10);
        set.add(8);
        set.add(4);
        set.add(5);
        set.add(2);
        assertTrue(true == set.contains(4));
        assertTrue(true == set.contains(10));
    }

    @Test
    public void remove_IsRemovedFromArray_true() {
        NumberSet mySet = new NumberSet();
        mySet.add(6);
        mySet.add(-4);
        mySet.add(2);
        mySet.add(10);
        mySet.add(8);
        mySet.add(4);
        mySet.add(5);
        mySet.add(2);

        mySet.remove(2);
        assertTrue(false == mySet.contains(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove_IsRemovedFromArray_false() {
        NumberSet mySet = new NumberSet();
        mySet.add(6);
        mySet.add(-4);
        mySet.add(2);
        mySet.add(10);
        mySet.add(8);
        mySet.add(4);
        mySet.add(5);
        mySet.add(2);

        mySet.remove(54);
    }

    @Test
    public void remove_CompareWithSet_true() {
        Set<Integer> set = new HashSet<Integer>();
        set.add(6);
        set.add(-4);
        set.add(2);
        set.add(10);
        set.add(8);
        set.add(4);
        set.add(5);
        set.add(2);

        set.remove(2);
        assertTrue(false == set.contains(2));
    }

    @Test(expected = IllegalStateException.class)
    public void getRandomValue_IsGeneratedProperly_false() {
        NumberSet mySet = new NumberSet();
        mySet.getRandomValue();
    }

    @Test
    public void getRandomValue_IsGeneratedProperly_notNull() {
        NumberSet mySet = new NumberSet();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);

        assertNotNull(mySet.getRandomValue());
    }

    @Test
    public void getRandomValue_IsGeneratedProperly_afterGenerate() {
        NumberSet mySet = new NumberSet();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.getRandomValue();

        assertEquals(2, mySet.getSize());
    }

    @Test
    public void getSumOfElements_IsSumCalculatedProperly_true() {
        NumberSet mySet = new NumberSet();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);

        assertEquals(6, mySet.getSumOfElements());
    }

    @Test
    public void getSumOfElements_IsGeneratedProperly_false() {
        NumberSet mySet = new NumberSet();
        mySet.add(-100);
        mySet.add(0);
        mySet.add(1);
        assertNotEquals(-101, mySet.getSumOfElements());
    }

    @Test(expected = IllegalStateException.class)
    public void getSumOfElements_IsGeneratedProperly_emptyArray() {
        NumberSet mySet = new NumberSet();
        mySet.getSumOfElements();
    }

    @Test
    public void divideAllElementsBy_IsDividedProperly_true() {
        NumberSet mySet = new NumberSet();
        mySet.add(2);
        mySet.add(4);
        mySet.add(6);
        mySet.divideAllElementsBy(2);
        assertTrue(true ==  mySet.contains(1));
        assertTrue(true == mySet.contains(2));
        assertTrue(true == mySet.contains(3));
    }

    @Test
    public void divideAllElementsBy_IsDividedProperly_false() {
        NumberSet mySet = new NumberSet();
        mySet.add(5);
        mySet.add(12);
        mySet.add(32);
        mySet.divideAllElementsBy(2);
        assertFalse(true ==  mySet.contains(3));
        assertFalse(true == mySet.contains(7));
        assertFalse(true == mySet.contains(19));
    }

    @Test(expected = ArithmeticException.class)
    public void divideAllElementsBy_IsDividedProperly_zero() {
        NumberSet mySet = new NumberSet();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.divideAllElementsBy(0);
    }

    @Test
    public void contains_doesArrayHasThisValue_true() {
        NumberSet mySet = new NumberSet();
        mySet.add(2);
        mySet.add(4);
        mySet.add(6);
        assertEquals(true, mySet.contains(2));
    }

    @Test
    public void contains_doesArrayHasThisValue_false() {
        NumberSet mySet = new NumberSet();
        mySet.add(2);
        mySet.add(4);
        mySet.add(6);
        assertEquals(false, mySet.contains(5));
    }

    @Test
    public void contains_doesArrayHasThisValue_afterRemove() {
        NumberSet mySet = new NumberSet();
        mySet.add(2);
        mySet.add(4);
        mySet.add(6);

        mySet.remove(4);
        assertEquals(false, mySet.contains(4));
    }

    @Test
    public void size_isSizeCalculatedProperly_true() {
        NumberSet mySet = new NumberSet();
        mySet.add(2);
        mySet.add(4);
        mySet.add(6);
        assertEquals(3, mySet.getSize());
    }

    @Test
    public void size_isSizeCalculatedProperly_false() {
        NumberSet mySet = new NumberSet();
        mySet.add(0);
        mySet.add(11);
        mySet.add(3);
        assertNotEquals(4, mySet.getSize());
    }

    @Test
    public void size_isSizeCalculatedProperly_afterRemove() {
        NumberSet mySet = new NumberSet();
        mySet.add(0);
        mySet.add(11);
        mySet.add(3);
        mySet.add(11);
        assertEquals(4, mySet.getSize());
        mySet.remove(11);
        assertEquals(2, mySet.getSize());
    }

}