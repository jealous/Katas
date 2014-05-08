package kata.bankOCR;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/11/12
 * Time: 12:36 AM
 * Kata Practise.
 */
public class PossibleAccountTest {
    @Test
    public void testGetPossibleAccounts() throws Exception {
        PossibleAccount account = new PossibleAccount();
        account.addNumber(NumberStringArray.ONE,1);
        List<String> accounts = account.getPossibleAccounts();
        assertThat(accounts, hasItems("7"));
    }

    @Test
    public void testGetPossibleAccountsTwoValue() throws Exception {
        PossibleAccount account = new PossibleAccount();
        account.addNumber(NumberStringArray.ONE,1);
        account.addNumber(NumberStringArray.ZERO,0);
        List<String> accounts = account.getPossibleAccounts();
        assertThat(accounts, hasItems("70", "18"));
    }
}
