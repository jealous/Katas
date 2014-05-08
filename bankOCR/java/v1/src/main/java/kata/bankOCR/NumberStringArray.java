package kata.bankOCR;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/5/12
 * Time: 11:35 PM
 * Kata Practise.
 */
public class NumberStringArray {
    public static String[] ZERO;
    public static String[] ONE;
    public static String[] TWO;
    public static String[] THREE;
    public static String[] FOUR;
    public static String[] FIVE;
    public static String[] SIX;
    public static String[] SEVEN;
    public static String[] EIGHT;
    public static String[] NINE;
    
    public static String[][] ALL_NUMBERS;

    static {
        ZERO = new String[]{" _ ",
                            "| |",
                            "|_|"};
        ONE = new String[]{ "   ",
                            "  |",
                            "  |"};
        TWO = new String[]{ " _ ",
                            " _|",
                            "|_ "};
        THREE = new String[]{" _ ",
                             " _|",
                             " _|"};
        FOUR = new String[]{"   ",
                            "|_|",
                            "  |"};
        FIVE = new String[]{" _ ",
                            "|_ ",
                            " _|"};
        SIX = new String[]{" _ ",
                           "|_ ",
                           "|_|"};
        SEVEN = new String[]{" _ ",
                             "  |",
                             "  |"};
        EIGHT = new String[]{" _ ",
                             "|_|",
                             "|_|"};
        NINE = new String[]{" _ ",
                            "|_|",
                            " _|"};

        ALL_NUMBERS = new String[][]{ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
    }
}
