package com.example.converter;

import com.example.model.RomanNumeral;

import java.util.List;

public class RomanToArabicConverter {

    public int romanToArabic(String romanNumber) {
        if (romanNumber == null || romanNumber.isEmpty()) {
            throw new IllegalArgumentException("Passed number is null!");
        }

        String romanNumeral = romanNumber.toUpperCase();

        return calculateResult(romanNumeral);
    }

    private int calculateResult(String romanNumeral) {
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();
        int i = 0;
        int result = 0;

        while (!romanNumeral.isEmpty() && i < romanNumerals.size()) {
            RomanNumeral symbol = romanNumerals.get(i);

            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (!romanNumeral.isEmpty()) {
            throw new IllegalArgumentException(romanNumeral + " cannot be converted to a Roman Numeral");
        }

        return result;
    }
}
