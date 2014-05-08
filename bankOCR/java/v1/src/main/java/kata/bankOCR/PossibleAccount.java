package kata.bankOCR;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/10/12
 * Time: 1:00 AM
 * Kata Practise.
 */
public class PossibleAccount {
    private List<List<Integer>> possibleNumberList;
    private CorrectDigitNumber corrector;
    private String trueAccount = "";
    
    public PossibleAccount(){
        corrector = new CorrectDigitNumber();
        possibleNumberList = new LinkedList<List<Integer>>();
    }
    
    public void addNumber(String[] digitInput, int trueValue){
        List<Integer> possibleNumbers = new LinkedList<Integer>();
        
        addTrueValue(possibleNumbers, trueValue);
        addPossibleValues(possibleNumbers, digitInput);

        possibleNumberList.add(possibleNumbers);
        trueAccount += Integer.toString(trueValue);
    }
    
    public List<String> getPossibleAccounts(){
        List<String> accounts = buildAccountsSingleError(possibleNumberList);
        return accounts;
    }
    
    private List<String> buildAccountsSingleError(List<List<Integer>> input){
        List<String> accounts = new LinkedList<String>();
        for (int index = 0 ; index < input.size() ; index++){
            List<Integer> errorNumberList = input.get(index);
            if (errorNumberList.size() > 0){
                for (int innerIndex = 1 ; innerIndex < errorNumberList.size() ; innerIndex++){
                    accounts.add(trueAccount.substring(0, index)
                            + Integer.toString(errorNumberList.get(innerIndex))
                            + trueAccount.substring(index + 1, trueAccount.length()));
                }
            }
        }
        return accounts;
    }
    
    private List<String> buildAccountsMultipleError(List<List<Integer>> input){
        List<String> accounts = new LinkedList<String>();
        if (input.size() == 0){
            accounts.add("");
        }else if(input.size() > 0){
            List<String> possibleNumbersAfterwards = buildAccountsMultipleError(input.subList(1, input.size()));
            List<Integer> numbers = input.get(0);
            for (int number: numbers){
                for (String possibleNumberAfterwards : possibleNumbersAfterwards){
                    accounts.add(Integer.toString(number) + possibleNumberAfterwards);
                }
            }
        }
        return accounts;
    }
    
    private void addTrueValue(List<Integer> numberList, int trueValue){
        if (trueValue != -1){
            numberList.add(trueValue);
        }
    }
    
    private void addPossibleValues(List<Integer> numberList, String[] digitInput){
        corrector.setDigitDisplayToCorrect(digitInput);
        numberList.addAll(corrector.getPossibleDigitList());
    }
}
