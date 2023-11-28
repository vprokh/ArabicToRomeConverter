package com.example.converter;

import com.example.model.BirthDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class RomanAwareObjectConverterTest {

    private static final int EXPECTED_YEAR = 1999;
    private static final int EXPECTED_MONTH = 11;
    private static final int EXPECTED_DAY = 10;

    @Mock
    private RomanToArabicConverter romanToArabicConverter;

    @InjectMocks
    private RomanAwareObjectConverter romanAwareObjectConverter;

    @BeforeEach
    void setUp() {
        Mockito.when(romanToArabicConverter.romanToArabic(ArgumentMatchers.anyString()))
                .thenReturn(EXPECTED_DAY)
                .thenReturn(EXPECTED_MONTH)
                .thenReturn(EXPECTED_YEAR);
    }

    @Test
    void convertFieldsToArabicShouldPopulateArabicNumbersToPassedObject() {
        BirthDate birthDate = createBirtDate("X", "XI", "MCMXCIX");

        romanAwareObjectConverter.convertFieldsToArabic(birthDate);

        // override equals
//        Assertions.assertEquals(expectedBirthDate, birthDate);
        Assertions.assertEquals(String.valueOf(EXPECTED_DAY), birthDate.getDay());
        Assertions.assertEquals(String.valueOf(EXPECTED_MONTH), birthDate.getMonth());
        Assertions.assertEquals(String.valueOf(EXPECTED_YEAR), birthDate.getYear());
    }

    private BirthDate createBirtDate(String day, String month, String year) {
        BirthDate birthDate = new BirthDate();

        birthDate.setDay(day);
        birthDate.setMonth(month);
        birthDate.setYear(year);

        return birthDate;
    }
}