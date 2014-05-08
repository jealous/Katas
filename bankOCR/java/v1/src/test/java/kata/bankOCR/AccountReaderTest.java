package kata.bankOCR;

import kata.bankOCR.fileUtilities.AccountReader;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/9/12
 * Time: 10:28 PM
 * Kata Practise.
 */
public class AccountReaderTest {
    @Test
     public void testReadAccount() throws Exception {
        AccountReader accountReader =
                new AccountReader("/Users/Cedric/Documents/workspace/KataBankOCR/src/test/testFiles/NormalInput.txt");
        String[] accountString = accountReader.readAccount();
        assertThat(accountString.length, equalTo(3));
        accountReader.close();
    }

    @Test
    public void testReadAccountNoMoreAccount() throws Exception {
        AccountReader accountReader =
                new AccountReader("/Users/Cedric/Documents/workspace/KataBankOCR/src/test/testFiles/NormalInput.txt");
        String[] accountString = accountReader.readAccount();
        accountString = accountReader.readAccount();
        accountString = accountReader.readAccount();
        assertThat(accountString.length, equalTo(0));
        accountReader.close();
    }

    @Test(expected = FileNotFoundException.class)
    public void testReadAccountNotExist() throws Exception {
        AccountReader accountReader =
                new AccountReader("/Users/Cedric/Documents/workspace/KataBankOCR/src/test/testFiles/NotExist.txt");
    }
}
