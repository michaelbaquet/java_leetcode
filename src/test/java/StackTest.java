

import old.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void testPush() {
        stack.push(0);
        assertEquals(stack.size(), 1);
    }
    
    @Test
    void testPop() {
        stack.push(0);
        assertEquals(stack.size(), 1);

        Integer pop = stack.pop();

        assertEquals(pop, Integer.valueOf(0));
        assertTrue(stack.isEmpty());

    }

    @Test
    void testPeek() {
        stack.push(0);
        stack.push(2);
        stack.push(4);

        assertEquals(stack.peek(), Integer.valueOf(4));
    }

    @Test
    void testPeekThrowsOnEmpty() {
        assertThrows(EmptyStackException.class, () -> {
            stack.peek();
        });
    }

    @Test
    void testPushPopAndSize() {
        Integer testVal1 = 1;
        Integer testVal2 = 2;
        Integer testVal3 = 3;

        stack.push(testVal1);
        stack.push(testVal2);
        stack.push(testVal3);

        assertEquals(stack.size(), 3);

        assertEquals(stack.pop(), testVal3);
        assertEquals(stack.pop(), testVal2);
        assertEquals(stack.pop(), testVal1);

        assertEquals(stack.size(), 0);
    }

    @Test
    void testResizeFunctionalityAndPushAndPopAndSize() {

        int desiredSize = 15;

        for(int i = 0; i < desiredSize; i++) {
            stack.push(i);
        }

        assertEquals(stack.size(), desiredSize);

        for(int i = desiredSize - 1; i >= 0; i--) {
            assertEquals(stack.pop(), Integer.valueOf(i));
        }

        assertEquals(stack.size(), 0);
    }

    @Test
    void shouldThrowExceptionWhenPopIsUsedOnEmpty() {
        assertThrows(EmptyStackException.class, () -> {
            stack.pop();
        });
    }
}