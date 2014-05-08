package kata.bankOCR;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/8/12
 * Time: 1:45 AM
 * Kata Practise.
 */
public class AccountValidator {
    private String accountNumber;
    public AccountValidator(){};

    public AccountValidator(String value){
        accountNumber = value;
    }
    
    public void setAccountNumber(String value){
        accountNumber = value;
    }

    public boolean isIllegible(){
        return -1 != accountNumber.indexOf("?");
    }

    public boolean isValidate(){
        boolean retVal = false;
        if (checkLength() && !isIllegible()){
            retVal = checkCheckSum();
        }
        return retVal;
    }

    private boolean checkLength(){
        boolean retVal = false;
        if (accountNumber.length() == 9) {
            retVal = true;
        }
        return retVal;
    }

    private boolean checkCheckSum(){
        int accountInteger = Integer.parseInt(accountNumber);
        int checkSum = 0;
        for (int i = 0 ; i < accountNumber.length(); i++){
            checkSum += accountInteger % 10 * (i + 1);
            accountInteger /= 10;
        }
        checkSum = checkSum % 11;
        return checkSum == 0;
    }
}
