package kata.bankOCR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/5/12
 * Time: 10:14 PM
 * Kata Practise.
 */
public class DigitDisplayLine {
    public DisplayState getLeft() {
        return left;
    }

    public DisplayState getCenter() {
        return center;
    }

    public DisplayState getRight() {
        return right;
    }

    public boolean equals(DigitDisplayLine toCompare){
        boolean retVal;
        retVal = left == toCompare.left
                && center == toCompare.center
                && right == toCompare.right;
        return retVal;
    }

    private DisplayState left;
    private DisplayState center;
    private DisplayState right;
    private String rawString;

    public DigitDisplayLine(String input) throws IllegalArgumentException{
        parseString(input);
    }
    
    public void parseString(String input) throws IllegalArgumentException{
        rawString = input;

        if (!isValidInput())
            throw new IllegalArgumentException("Input is not valid display pattern.");

        translateString();
    }

    private void translateString(){
        left = translateCharacter(rawString.charAt(0));
        center = translateCharacter(rawString.charAt(1));
        right = translateCharacter(rawString.charAt(2));
    }

    private DisplayState translateCharacter(char inputChar){
        DisplayState inputState;
        if (inputChar == '|'){
            inputState = DisplayState.PIPE;
        } else if (inputChar == '_'){
            inputState = DisplayState.SCORE;
        } else {
            inputState = DisplayState.EMPTY;
        }
        return inputState;
    }
    
    private boolean isValidInput(){
        boolean retVal;
        retVal = isValidLength() && isValidCharacter();
        return retVal;
    }
    
    private boolean isValidLength(){
        boolean  retVal = false;
        if (rawString.length() == 3){
            retVal = true;
        }
        return retVal;
    }
    
    private boolean isValidCharacter(){
        boolean retVal;
        Pattern digitPattern = Pattern.compile("[_| ]{3}");
        Matcher digitMatcher = digitPattern.matcher(rawString);
        retVal = digitMatcher.matches();
        return retVal;
    }
}
