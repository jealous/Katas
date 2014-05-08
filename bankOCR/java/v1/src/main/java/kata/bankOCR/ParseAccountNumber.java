package kata.bankOCR;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/6/12
 * Time: 12:19 AM
 * Kata Practise.
 */
public class ParseAccountNumber {
    private PossibleAccount possibleAccount;
    public ParseAccountNumber(){
    }

    public int getIntAccountNumber(String[] input) throws IllegalArgumentException{
        String account = getStringAccountNumber(input);
        return Integer.parseInt(account);
    }
    
    public String getStringAccountNumber(String[] input) throws IllegalArgumentException{
        checkInput(input);
        return parseInput(input);
    }

    public List<String> getPossibleAccounts(){
        return possibleAccount.getPossibleAccounts();
    }
    
    private String parseInput(String[] input){
        StringBuilder account = new StringBuilder();
        possibleAccount = new PossibleAccount();
        for (int index = 0 ; index < 9 ; index ++){
            account.append(parseSingleNumberToString(input, index * 3));
        }
        return account.toString();
    }

    private char parseSingleNumberToString(String[] input, int startIndex){
        char retVal = '?';
        int number = parseSingleNumber(input, startIndex);
        if (number != -1){
            retVal = Character.forDigit(number, 10);
        }
        return retVal;
    }
    
    private int parseSingleNumber(String[] input, int startIndex){
        String[] numberDisplayStrings = getDisplayString(input, startIndex);
        DigitDisplay numberDisplay = new DigitDisplay(numberDisplayStrings);
        int number = DigitDisplayNumbers.getInstance().getNumberFromDisplay(numberDisplay);
        possibleAccount.addNumber(numberDisplayStrings, number);
        return number;
    }
    
    private String[] getDisplayString(String[] input, int startIndex){
        String[] numberDisplay = new String[input.length];
        for (int index = 0 ; index < numberDisplay.length && index < 3; index ++){
            numberDisplay[index] = input[index].substring(startIndex,startIndex + 3);
        }
        return numberDisplay;
    }

    private void checkInput(String[] input){
        if (input.length != 3
                || input[0].length() != 27
                || input[1].length() != 27
                || input[2].length() != 27){
            throw new IllegalArgumentException("Four line with first three lines have 27 characters.");
        }
    }
}
