package com.example.calculator;

import com.example.converter.RomanToArabicConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
class RomanToArabicCalculatorTest {

    private static final String VALID_ROME_NUMBER = "X";

    @Mock
    private RomanToArabicConverter romanToArabicConverter;

    @InjectMocks
    private RomanToArabicCalculator romanToArabicCalculator;

    @BeforeEach
    void setUp() {
//        romanToArabicConverter = Mockito.mock(RomanToArabicConverter.class);
//        romanToArabicCalculator = new RomanToArabicCalculator(romanToArabicConverter);
    }

    @Test
    void sumShouldReturnArabicSumNumberWhenTwoRomeNumbersPassed() {
        Mockito.when(romanToArabicConverter.romanToArabic(ArgumentMatchers.anyString()))
                .thenReturn(10)
                .thenReturn(1);

//        Mockito.when(romanToArabicConverter.romanToArabic(ArgumentMatchers.eq("X")))
//                .thenReturn(10)
//                .thenReturn(1);

//        Mockito.doReturn(10).when(romanToArabicConverter).romanToArabic(ArgumentMatchers.anyString());
//        Mockito.when(romanToArabicConverter.romanToArabicTwoParams(
//                ArgumentMatchers.eq(VALID_ROME_NUMBER), ArgumentMatchers.any(BirthDate.class))).thenReturn(1);

        int actualSum = romanToArabicCalculator.sum(VALID_ROME_NUMBER, VALID_ROME_NUMBER);

        Assertions.assertEquals(11, actualSum);
    }

    @ParameterizedTest
    @CsvSource(value = {"'',''", "test,X", "X,test", "test,test", "null,V", "V,null", "null,null"}, nullValues = "null")
    void sumShouldThrowIllegalArgumentExceptionWhenIncorrectRomeNumberIsPassed(
            String romeNumber1, String romeNumber2) {
//        Mockito.when(romanToArabicConverter.romanToArabic(ArgumentMatchers.any()))
//                .thenThrow(IllegalArgumentException.class);

        Mockito.doThrow(IllegalArgumentException.class)
                .when(romanToArabicConverter).romanToArabic(ArgumentMatchers.any());

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> romanToArabicCalculator.sum(romeNumber1, romeNumber2));
    }
}
