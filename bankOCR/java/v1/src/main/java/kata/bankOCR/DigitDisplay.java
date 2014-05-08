package kata.bankOCR;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/5/12
 * Time: 11:17 PM
 * Kata Practise.
 */
public class DigitDisplay {
    private DigitDisplayLine topLine;
    private DigitDisplayLine middleLine;
    private DigitDisplayLine bottomLine;
    private String[] stringArray;
    
    public DigitDisplay(String[] inputs) throws IllegalArgumentException{
        initializeDisplayLine(inputs);
    }
    
    public DigitDisplay() throws IllegalArgumentException{
        String[] inputs = new String[]{"   ", "   ", "   "};
        initializeDisplayLine(inputs);
    }
    
    public String[] getStringArray(){
        return stringArray;
    }
    
    public void initializeDisplayLine(String[] inputs) throws IllegalArgumentException{
        stringArray = inputs;
        checkInputLength(inputs);
        
        topLine = new DigitDisplayLine(inputs[0]);
        middleLine = new DigitDisplayLine(inputs[1]);
        bottomLine = new DigitDisplayLine(inputs[2]);
    }
    
    private void checkInputLength(String[] inputs) throws IllegalArgumentException{
        if (inputs.length != 3){
            throw new IllegalArgumentException("Each display has three lines.");
        }
    }

    public DigitDisplayLine getTopLine() {
        return topLine;
    }

    public DigitDisplayLine getMiddleLine() {
        return middleLine;
    }

    public DigitDisplayLine getBottomLine() {
        return bottomLine;
    }

    public boolean equals(DigitDisplay toCompare){
        boolean retVal;
        retVal = topLine.equals(toCompare.topLine)
                && middleLine.equals(toCompare.middleLine)
                && bottomLine.equals(toCompare.bottomLine);
        return retVal;
    }
}
