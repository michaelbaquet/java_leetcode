import old.ValidPalidrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidPalidromeTest {

    ValidPalidrome validPalidrome = new ValidPalidrome();

    @Test
    public void testTheTest() {
        String actual = validPalidrome.test("name");

        assertEquals("name1", actual);
    }

    @Test
    public void isPalindromeTestPassingTest() {
        String input = "A man, a plan, a canal: Panama";

        boolean expected = validPalidrome.isPalindrome(input);

        assertTrue(expected);
    }

    @Test
    public void isPalindromeFailTest() {
        String input = "This is not a Palindrome";

        boolean expected = validPalidrome.isPalindrome(input);

        assertFalse(expected);
    }

}