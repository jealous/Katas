package kata.bankOCR;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/8/12
 * Time: 1:30 AM
 * Kata Practise.
 */
public class DigitDisplayNumbersTest {
    @Test
    public void testGetInstance() throws Exception {
        assertThat(DigitDisplayNumbers.getInstance(), notNullValue());
    }

    @Test
    public void testGetNumberFromDisplayZero() throws Exception {
        String[] digitString = new String[]{" _ ", "| |", "|_|"};
        int retVal = DigitDisplayNumbers.getInstance().getNumberFromDisplay(new DigitDisplay(digitString));
        assertThat(retVal, equalTo(0));
    }

    @Test
    public void testGetNumberFromDisplayOne() throws Exception {
        String[] digitString = new String[]{"   ", "  |", "  |"};
        int retVal = DigitDisplayNumbers.getInstance().getNumberFromDisplay(new DigitDisplay(digitString));
        assertThat(retVal, equalTo(1));
    }

    @Test
    public void testGetNumberFromDisplayTwo() throws Exception {
        String[] digitString = new String[]{" _ ", " _|", "|_ "};
        int retVal = DigitDisplayNumbers.getInstance().getNumberFromDisplay(new DigitDisplay(digitString));
        assertThat(retVal, equalTo(2));
    }

    @Test
    public void testGetNumberFromDisplayThree() throws Exception {
        String[] digitString = new String[]{" _ ", " _|", " _|"};
        int retVal = DigitDisplayNumbers.getInstance().getNumberFromDisplay(new DigitDisplay(digitString));
        assertThat(retVal, equalTo(3));
    }

    @Test
    public void testGetNumberFromDisplayFour() throws Exception {
        String[] digitString = new String[]{"   ", "|_|", "  |"};
        int retVal = DigitDisplayNumbers.getInstance().getNumberFromDisplay(new DigitDisplay(digitString));
        assertThat(retVal, equalTo(4));
    }

    @Test
    public void testGetNumberFromDisplayFive() throws Exception {
        String[] digitString = new String[]{" _ ", "|_ ", " _|"};
        int retVal = DigitDisplayNumbers.getInstance().getNumberFromDisplay(new DigitDisplay(digitString));
        assertThat(retVal, equalTo(5));
    }

    @Test
    public void testGetNumberFromDisplaySix() throws Exception {
        String[] digitString = new String[]{" _ ", "|_ ", "|_|"};
        int retVal = DigitDisplayNumbers.getInstance().getNumberFromDisplay(new DigitDisplay(digitString));
        assertThat(retVal, equalTo(6));
    }

    @Test
    public void testGetNumberFromDisplaySeven() throws Exception {
        String[] digitString = new String[]{" _ ", "  |", "  |"};
        int retVal = DigitDisplayNumbers.getInstance().getNumberFromDisplay(new DigitDisplay(digitString));
        assertThat(retVal, equalTo(7));
    }

    @Test
    public void testGetNumberFromDisplayEight() throws Exception {
        String[] digitString = new String[]{" _ ", "|_|", "|_|"};
        int retVal = DigitDisplayNumbers.getInstance().getNumberFromDisplay(new DigitDisplay(digitString));
        assertThat(retVal, equalTo(8));
    }

    @Test
    public void testGetNumberFromDisplayNine() throws Exception {
        String[] digitString = new String[]{" _ ", "|_|", " _|"};
        int retVal = DigitDisplayNumbers.getInstance().getNumberFromDisplay(new DigitDisplay(digitString));
        assertThat(retVal, equalTo(9));
    }

    @Test
    public void testGetNumberFromDisplayError() throws Exception {
        String[] digitString = new String[]{" _|", "|_|", "|_|"};
        int retVal = DigitDisplayNumbers.getInstance().getNumberFromDisplay(new DigitDisplay(digitString));
        assertThat(retVal, equalTo(-1));
    }
}
