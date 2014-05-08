package kata.bankOCR;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/9/12
 * Time: 11:13 PM
 * Kata Practise.
 */
public class OutputFormatter {
    
    private static String ILLEGIBLE = "ILL";
    private static String ERROR = "ERR";

    private AccountValidator validator;

    public OutputFormatter(AccountValidator validator){
        this.validator = validator;
    }
    
    public String getOutputString(String account){
        StringBuilder retVal = new StringBuilder(account);
        validator.setAccountNumber(account);
        if (validator.isIllegible()){
            retVal.append(" " + ILLEGIBLE);
        }else if(!validator.isValidate()){
            retVal.append(" " + ERROR);
        }
        retVal.append('\n');
        return retVal.toString();
    }

}
