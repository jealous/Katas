package kata.bankOCR;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/8/12
 * Time: 2:00 AM
 * Kata Practise.
 */
public class AccountValidatorTest {

    @Test
    public void testIsValidateTrue(){
        AccountValidator validator = new AccountValidator("345882865");
        assertThat(validator.isValidate(), equalTo(true));
    }

    @Test
    public void testIsValidateFalse(){
        AccountValidator validator = new AccountValidator("345882875");
        assertThat(validator.isValidate(), equalTo(false));
    }

    @Test
    public void testIsIllegibleTrue(){
        AccountValidator validator = new AccountValidator("34588?865");
        assertThat(validator.isIllegible(), equalTo(true));
    }

    @Test
    public void testIsIllegibleFalse(){
        AccountValidator validator = new AccountValidator("345882865");
        assertThat(validator.isIllegible(), equalTo(false));
    }
}
