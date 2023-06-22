package current;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicate217Test {


    @BeforeEach
    void setUp() {
    }

    @Test
    public void containsDuplicates() {
        int[] nums = {1,2,3,4,5,5};

        assertTrue(ContainsDuplicate217.containsDuplicate217(nums));
    }

    @Test
    public void containsDuplicates2() {
        int[] nums = {1,2,3,4,5,1};

        assertTrue(ContainsDuplicate217.containsDuplicate217(nums));
    }


    @Test
    public void doesNotContainDuplicates() {
        int[] nums = {1,2,3,4,5};

        assertFalse(ContainsDuplicate217.containsDuplicate217(nums));
    }

    @Test
    public void isSingleNumInArray() {
        int[] nums = {3};

        assertFalse(ContainsDuplicate217.containsDuplicate217(nums));
    }

    @Test
    public void isNull() {
        int[] nums = null;

        assertFalse(ContainsDuplicate217.containsDuplicate217(nums));
    }

}