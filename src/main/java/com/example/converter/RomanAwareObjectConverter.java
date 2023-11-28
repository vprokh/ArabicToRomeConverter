package com.example.converter;

import com.example.model.BirthDate;

public class RomanAwareObjectConverter {

    private RomanToArabicConverter romanToArabicConverter;

    public RomanAwareObjectConverter(RomanToArabicConverter romanToArabicConverter) {
        this.romanToArabicConverter = romanToArabicConverter;
    }

    public void convertFieldsToArabic(BirthDate birthDate) {
        String day = String.valueOf(romanToArabicConverter.romanToArabic(birthDate.getDay()));
        String month = String.valueOf(romanToArabicConverter.romanToArabic(birthDate.getMonth()));
        String year = String.valueOf(romanToArabicConverter.romanToArabic(birthDate.getYear()));

        birthDate.setDay(day);
        birthDate.setMonth(month);
        birthDate.setYear(year);
    }
}
