package kata.bankOCR;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/10/12
 * Time: 11:40 PM
 * Kata Practise.
 */
public class AdvancedParseAccountNumber
{
    private ParseAccountNumber parser;
    private AccountValidator validator;
    private String[] accountString;
    
    public AdvancedParseAccountNumber(){
        initialize();
    }

    private void initialize(){
        parser = new ParseAccountNumber();
        validator = new AccountValidator();
    }
    
    public String parse(String[] input){
        accountString = input;

        String account = getAccount();
        
        validator.setAccountNumber(account);
        if (!validator.isValidate()){
            account = getValidatePossibleAccount(account);
        }

        return account;
    }
    
    private String getAccount(){
        String account = parser.getStringAccountNumber(accountString);
        return account;
    }
    
    private String getValidatePossibleAccount(String originalAccount){
        List<String> possibleValidateAccounts = getValidatePossibleAccounts();
        if (possibleValidateAccounts.size() == 1)
            return possibleValidateAccounts.get(0);
        else
            return originalAccount;
    }
    
    public List<String> getValidatePossibleAccounts(){
        List<String> possibleAccounts = parser.getPossibleAccounts();
        List<String> possibleValidateAccounts = new LinkedList<String>();
        for (String possibleAccount : possibleAccounts){
            validator.setAccountNumber(possibleAccount);
            if (validator.isValidate()){
                possibleValidateAccounts.add(possibleAccount);
            }
        }
        return possibleValidateAccounts;
    }
}
