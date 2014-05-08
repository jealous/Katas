package kata.bankOCR;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/11/12
 * Time: 1:07 AM
 * Kata Practise.
 */
public class AdvancedParseAccountNumberTest {

    private String[] input;
    private String[] inputError;
    private String[] inputIllegible;
    private AdvancedParseAccountNumber parser;

    @Before
    public void setUp(){
        input = new String[3];
        input[0] = "    _  _     _  _  _  _  _ ";
        input[1] = "  | _| _||_||_ |_   ||_||_|";
        input[2] = "  ||_  _|  | _||_|  ||_| _|";
        inputError = new String[3];
        inputError[0] = "    _  _     _  _  _  _  _ ";
        inputError[1] = "  | _| _||_||_ |_   ||_|| |";
        inputError[2] = "  ||_  _|  | _||_|  ||_| _|";
        inputIllegible = new String[3];
        inputIllegible[0] = "                           ";
        inputIllegible[1] = "  |  |  |  |  |  |  |  |  |";
        inputIllegible[2] = "  |  |  |  |  |  |  |  |  |";
        parser = new AdvancedParseAccountNumber();
    }

    @Test
    public void testParse() throws Exception {
        String account = parser.parse(input);
        assertThat(account, equalTo("123456789"));
    }

    @Test
    public void testParseError() throws Exception {
        String account = parser.parse(inputError);
        assertThat(account, equalTo("12345678?"));
    }

    @Test
    public void testParseIllegible() throws Exception {
        String account = parser.parse(inputIllegible);
        assertThat(account, equalTo("711111111"));
    }

    @Test
    public void test2ParseIllegible() throws Exception {
        inputIllegible[0] = " _  _  _  _  _  _  _  _  _ ";
        inputIllegible[1] = "  |  |  |  |  |  |  |  |  |";
        inputIllegible[2] = "  |  |  |  |  |  |  |  |  |";
        String account = parser.parse(inputIllegible);
        assertThat(account, equalTo("777777177"));
    }
}
