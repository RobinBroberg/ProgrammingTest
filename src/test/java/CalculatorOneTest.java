import CalculatorOne.CalculatorOne;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorOneTest {

    @Test
    public void testValidateInput_True() {
        String input = "5+5";

        boolean result = CalculatorOne.validateInput(input);

        Assertions.assertTrue(result);
    }

    @Test
    public void testValidateInput_False() {
        String input = "5+5+6";

        boolean result = CalculatorOne.validateInput(input);

        Assertions.assertFalse(result);
    }

    @Test
    public void testPerformCalculation() {
        String input = "5+3";
        double expected = 8;
        double actual = CalculatorOne.performCalculation(input);
        assertEquals(expected, actual);
    }

}