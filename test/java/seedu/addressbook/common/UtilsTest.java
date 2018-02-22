package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    @Test
    public void isAnyNull() throws Exception {
        //empty list
        assertNoNull();

        //Any null object
        assertAnyNull( "abc", null, "def");
        assertAnyNull((Object) null);
        assertAnyNull(null, null, "hello");
        assertAnyNull(null, "good", null, null);

        //No null objects
        assertNoNull("hello", "world", "good", "bye");
        assertNoNull("cats", "felines");

    }

    private void assertAnyNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertNoNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }

}
