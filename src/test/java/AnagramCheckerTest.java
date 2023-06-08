import AnagramChecker.AnagramChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnagramCheckerTest {

    @Test
    public void testIsAnagram_SameLengthAndChars() {
        String stringOne = "army";
        String stringTwo = "mary";

        boolean result = AnagramChecker.isAnagram(stringOne, stringTwo);

        Assertions.assertTrue(result);
    }



    @Test
    public void testIsAnagram_SameLengthDifferentChars() {
        String stringOne = "mary";
        String stringTwo = "john";

        boolean result = AnagramChecker.isAnagram(stringOne, stringTwo);

        Assertions.assertFalse(result);
    }

    @Test
    public void testIsAnagram_DifferentLength() {
        String stringOne = "mary";
        String stringTwo = "sally";

        boolean result = AnagramChecker.isAnagram(stringOne, stringTwo);

        Assertions.assertFalse(result);
    }
}