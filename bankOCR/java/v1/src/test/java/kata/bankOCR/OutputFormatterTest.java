package kata.bankOCR;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/9/12
 * Time: 11:25 PM
 * Kata Practise.
 */
public class OutputFormatterTest {
    private OutputFormatter formatter;
    
    @Before
    public void setUp(){
        formatter = new OutputFormatter(new AccountValidator());
    }
    
    @Test
    public void testGetOutputStringNormal() throws Exception {
        String outcome = formatter.getOutputString("457508000");
        assertThat(outcome, equalTo("457508000\n"));
    }

    @Test
    public void testGetOutputStringError() throws Exception {
        String outcome = formatter.getOutputString("664371495");
        assertThat(outcome, equalTo("664371495 ERR\n"));
    }

    @Test
    public void testGetOutputStringIllegible() throws Exception {
        String outcome = formatter.getOutputString("86110??36");
        assertThat(outcome, equalTo("86110??36 ILL\n"));
    }
}
