package kata.bankOCR;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/5/12
 * Time: 10:57 PM
 * Test
 */
public class DigitDisplayLineTest {
    private DigitDisplayLine digitLine;

    @Test(expected = IllegalArgumentException.class)
    public void testDigitDisplayLineErrorLength(){
       digitLine = new DigitDisplayLine("_ ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDigitDisplayLineErrorChar(){
        digitLine = new DigitDisplayLine("_1 ");
    }

    @Test
    public void testDigitDisplayLine(){
        digitLine = new DigitDisplayLine("__ ");
        assertThat(digitLine.getLeft(), equalTo(DisplayState.SCORE));
        assertThat(digitLine.getCenter(), equalTo(DisplayState.SCORE));
        assertThat(digitLine.getRight(), equalTo(DisplayState.EMPTY));
    }
    
    @Test
    public void testParseString() throws Exception {
        digitLine = new DigitDisplayLine("__ ");
        digitLine.parseString("|||");
        assertThat(digitLine.getLeft(), equalTo(DisplayState.PIPE));
        assertThat(digitLine.getCenter(), equalTo(DisplayState.PIPE));
        assertThat(digitLine.getRight(), equalTo(DisplayState.PIPE));
    }
    
    @Test
    public void testEqual(){
        digitLine = new DigitDisplayLine("___");
        DigitDisplayLine toCompare = new DigitDisplayLine("___");
        assertThat(digitLine.equals(toCompare), equalTo(true));
    }

    @Test
    public void testEqualFalse(){
        digitLine = new DigitDisplayLine("___");
        DigitDisplayLine toCompare = new DigitDisplayLine("_ _");
        assertThat(digitLine.equals(toCompare), equalTo(false));
    }
}
