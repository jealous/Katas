package com.zhuangpeiyu.kata;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


/**
 * @author Cedric
 * Date: 5/9/14
 * Time: 1:25 AM
 */
@Test
public class RomanNumeralsTest {

    private RomanNumerals romanNumerals = new RomanNumerals();

    @DataProvider(name = "numToRoman")
    private Object[][] testData(){
        return new Object[][]{
                {1, "I"},
                {2, "II"},
                {3, "III"},
                {4, "IV"},
                {5, "V"},
                {6, "VI"},
                {7, "VII"},
                {8, "VIII"},
                {9, "IX"},
                {10, "X"},
        };
    }

    @Test(dataProvider = "numToRoman")
    public void numberToRoman(int input, String expected) {
        String result = romanNumerals.intToRoman(input);
        assertThat(result, equalTo(expected));
    }
}
