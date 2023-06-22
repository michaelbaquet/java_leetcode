import old.CompressString;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CompressStringTest {

    @Test
    void compressString() {
        String input = "Aaabccc";

        String output = CompressString.compressString(input);

        assertEquals("Aa2bc3", output);
    }
}



















