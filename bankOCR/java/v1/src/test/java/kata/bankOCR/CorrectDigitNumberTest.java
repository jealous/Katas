package kata.bankOCR;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/10/12
 * Time: 12:08 AM
 * Kata Practise.
 */
public class CorrectDigitNumberTest {
    private CorrectDigitNumber correctDigitNumber = new CorrectDigitNumber();
    
    @Test
    public void testGetPossibleDigitListSeven() throws Exception {
        String[] inputs = new String[]{" _ ",
                                       "  |",
                                       "  |"};
        correctDigitNumber.setDigitDisplayToCorrect(inputs);
        List<Integer> resultList = correctDigitNumber.getPossibleDigitList();
        assertThat(resultList, hasItems(1));
    }

    @Test
    public void testGetPossibleDigitListFive() throws Exception {
        String[] inputs = new String[]{" _ ",
                                       "|_ ",
                                       " _|"};
        correctDigitNumber.setDigitDisplayToCorrect(inputs);
        List<Integer> resultList = correctDigitNumber.getPossibleDigitList();
        assertThat(resultList, hasItems(6, 9));
    }
}
