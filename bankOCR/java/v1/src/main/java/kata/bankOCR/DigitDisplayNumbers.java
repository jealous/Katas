package kata.bankOCR;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/5/12
 * Time: 11:22 PM
 * Kata Practise.
 */
public class DigitDisplayNumbers {
    private List<DigitDisplay> NUMBERS = new LinkedList<DigitDisplay>();
    private static DigitDisplayNumbers instance = new DigitDisplayNumbers();

    public static DigitDisplayNumbers getInstance(){
        return instance;
    }
    
    public int getNumberFromDisplay(DigitDisplay display){
        for (int i = 0 ; i < NUMBERS.size() ; i++){
            if (NUMBERS.get(i).equals(display)){
                return i;
            }
        }
        return -1;
    }

    private DigitDisplayNumbers(){
        for (String[] numberString : NumberStringArray.ALL_NUMBERS){
            NUMBERS.add( new DigitDisplay(numberString));
        }
    }
}
