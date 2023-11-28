package com.example.calculator;

import com.example.converter.RomanToArabicConverter;
import com.example.util.MathUtil;

public class RomanToArabicCalculator {

    public static final String DEFAULT_ROMAN_NUMERAL = "X";
    private final RomanToArabicConverter romanToArabicConverter;

    public RomanToArabicCalculator(RomanToArabicConverter romanToArabicConverter) {
        this.romanToArabicConverter = romanToArabicConverter;
    }

    public int sum(String romeNumber1, String romeNumber2) {
        int arabicNumber1 = romanToArabicConverter.romanToArabic(romeNumber1);
        int arabicNumber2 = romanToArabicConverter.romanToArabic(romeNumber2);

        return arabicNumber1 + arabicNumber2;
    }

    public int sumUsingUtilClass(String romeNumber1, String romeNumber2) {
        int arabicNumber1 = romanToArabicConverter.romanToArabic(romeNumber1);
        int arabicNumber2 = romanToArabicConverter.romanToArabic(romeNumber2);

        return MathUtil.sum(arabicNumber1, arabicNumber2);
    }

    public int exampleSumWithDefaultArguments() {
        int arabicNumber1 = romanToArabicConverter.romanToArabic(DEFAULT_ROMAN_NUMERAL);
        int arabicNumber2 = romanToArabicConverter.romanToArabic(DEFAULT_ROMAN_NUMERAL);

        return arabicNumber1 + arabicNumber2;
    }
}
