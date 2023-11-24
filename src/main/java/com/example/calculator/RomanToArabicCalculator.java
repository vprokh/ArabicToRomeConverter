package com.example.calculator;

import com.example.converter.RomanToArabicConverter;

public class RomanToArabicCalculator {

    private final RomanToArabicConverter romanToArabicConverter;

    public RomanToArabicCalculator(RomanToArabicConverter romanToArabicConverter) {
        this.romanToArabicConverter = romanToArabicConverter;
    }

    public int sum(String romeNumber1, String romeNumber2) {
        int arabicNumber1 = romanToArabicConverter.romanToArabic(romeNumber1);
        int arabicNumber2 = romanToArabicConverter.romanToArabic(romeNumber2);

        return arabicNumber1 + arabicNumber2;
    }
}
