package com.example;

import com.example.converter.RomanToArabicConverter;

public class Main {
    public static void main(String[] args) {
        RomanToArabicConverter arabicToRomanConverter = new RomanToArabicConverter();

        System.out.println(arabicToRomanConverter.romanToArabic("X"));
    }
}
