package com.zhuangpeiyu.kata;

/**
 * @author Cedric
 * Date: 5/9/14
 * Time: 1:22 AM
 */
public class RomanNumerals {
    public String intToRoman(int number) {
        StringBuilder builder = new StringBuilder();
        if (number == 4){
            builder.append("I").append("V");
            number -= 4;
        }
        if (number >= 5){
            builder.append("V");
            number = number - 5;
        }
        if (number <= 3){
            while(number-- > 0){
                builder.append("I");
            }
        }
        return builder.toString();
    }
}
