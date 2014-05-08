package kata.bankOCR;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/9/12
 * Time: 11:46 PM
 * Kata Practise.
 */
public class CorrectDigitNumber {
    private String[] displayString;
    private List<Integer> possibleDigitList;

    public CorrectDigitNumber(){
        initialize();
    }

    public void setDigitDisplayToCorrect(String[] display){
        initialize();
        displayString = display;
    }
    
    public List<Integer> getPossibleDigitList(){
        correct();
        return possibleDigitList;
    }
    
    private void initialize(){
        displayString = new String[3];
        possibleDigitList = new LinkedList<Integer>();
    }
    
    private void correct(){
        for (int line = 0 ; line < displayString.length ; line++){
            for (int index = 0 ; index < displayString[line].length() ; index++){
                correct(line, index);
            }
        }
    }
    
    private void correct(int line, int index){
        char state = displayString[line].charAt(index);
        if (state == ' '){
            checkPossibleState(line, index, '|');
            checkPossibleState(line, index, '_');
        }else if(state == '|'){
            checkPossibleState(line, index, ' ');
        }else if(state == '_'){
            checkPossibleState(line, index, ' ');
        }
    }

    private void checkPossibleState(int line, int index, char toChange){
        String[] copy = displayString.clone();
        copy[line] = copy[line].substring(0,index) + toChange + copy[line].substring(index + 1,copy[index].length());
        int possibleNumber = DigitDisplayNumbers.getInstance().getNumberFromDisplay(new DigitDisplay(copy));
        if (possibleNumber != -1 && !possibleDigitList.contains(possibleNumber)) {
            possibleDigitList.add(possibleNumber);
        }
    }
}
