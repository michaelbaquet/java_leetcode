import old.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class QueueTest {

    Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    void testEnqueue() {
        queue.enqueue(6);
        queue.enqueue(0);

        assertEquals(queue.size(), 2);
        assertEquals(queue.peek(), Integer.valueOf(6));
    }

    @Test
    void testDequeue() {
        queue.enqueue(6);
        queue.enqueue(3);
        queue.enqueue(2);

        assertEquals(queue.size(), 3);

        Integer dequeueFirst = queue.dequeue();
        Integer dequeueSecond = queue.dequeue();
        Integer dequeueThird = queue.dequeue();

        assertEquals(queue.size(), 0);

        assertEquals(dequeueFirst, Integer.valueOf(6));
        assertEquals(dequeueSecond, Integer.valueOf(3));
        assertEquals(dequeueThird, Integer.valueOf(2));
    }

    @Test
    void shouldThrowWhenDequeueOnEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    void shouldBeEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void peekShouldReturnFirstElement() {
        queue.enqueue(1);
        queue.enqueue(3);
        assertEquals(queue.peek(), Integer.valueOf(1));
    }

}