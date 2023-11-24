package com.example.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// USUALLY for enum/POJO (Plain old Java object) classes we do not write unit tests
// because they simple as is so no need to write some tests
// but when there is some logic there (different of getters/setters etc) we have to cover it with tests
class RomanNumeralTest {

    // declare the expected result
    private static final List<RomanNumeral> EXPECTED_ENUM_ELEMENTS_LIST = Arrays.asList(
            RomanNumeral.M,
            RomanNumeral.CM,
            RomanNumeral.D,
            RomanNumeral.CD,
            RomanNumeral.C,
            RomanNumeral.XC,
            RomanNumeral.L,
            RomanNumeral.XL,
            RomanNumeral.X,
            RomanNumeral.IX,
            RomanNumeral.V,
            RomanNumeral.IV,
            RomanNumeral.I
    );

    // Also it is the case how we can test static methods (we do not create instance of testing class)
    @Test
    void getReverseSortedValuesShouldReturnEnumValuesInReversedOrder() {
        List<RomanNumeral> actual = RomanNumeral.getReverseSortedValues();

        Assertions.assertEquals(EXPECTED_ENUM_ELEMENTS_LIST, actual);
    }
}