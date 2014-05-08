package kata.bankOCR;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/6/12
 * Time: 12:09 AM
 * Kata Practise.
 */
public class DigitDisplayTest {
    private DigitDisplay digitDisplay;

    @Before
    public void setUp() throws Exception {
        digitDisplay = new DigitDisplay(NumberStringArray.FIVE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDigitDisplayError() throws Exception {
        String[] input = new String[] {"___", "|||"};
        digitDisplay = new DigitDisplay(input);
    }
    
    @Test
    public void testInitializeDisplayLine() throws Exception {
        digitDisplay.initializeDisplayLine(NumberStringArray.SIX);
    }

    @Test
    public void testEqualsFalse() throws Exception {
        DigitDisplay toCompare = new DigitDisplay(NumberStringArray.SEVEN);
        assertThat(toCompare.equals(digitDisplay), equalTo(false));
    }

    @Test
    public void testEqualsTrue() throws Exception {
        DigitDisplay toCompare = new DigitDisplay(NumberStringArray.FIVE);
        assertThat(toCompare.equals(digitDisplay), equalTo(true));
    }
}
