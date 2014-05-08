package kata.bankOCR;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/6/12
 * Time: 12:40 AM
 * Kata Practise.
 */
public class ParseAccountNumberTest {
    private String[] input;
    private String[] inputError;
    private ParseAccountNumber parser;

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
        parser = new ParseAccountNumber();
    }

    @Test
    public void testGetIntAccountNumber() throws Exception {
        int account = parser.getIntAccountNumber(input);
        assertThat(account, equalTo(123456789));
    }

    @Test
      public void testGetStringAccountNumber() throws Exception {
        String account = parser.getStringAccountNumber(input);
        assertThat(account, equalTo("123456789"));
    }

    @Test
    public void testGetStringAccountNumberError() throws Exception {
        String account = parser.getStringAccountNumber(inputError);
        assertThat(account, equalTo("12345678?"));
    }

    @Test
    public void testGetPossibleAccount() throws Exception {
        String account = parser.getStringAccountNumber(input);
        List<String> possibleAccounts = parser.getPossibleAccounts();
        assertThat(possibleAccounts, hasItems("723456789"));
    }
}
