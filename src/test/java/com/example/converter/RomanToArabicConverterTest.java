package com.example.converter;

import com.example.model.BirthDate;
import com.example.model.RomanNumeral;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

class RomanToArabicConverterTest {

    private RomanToArabicConverter romanToArabicConverter;

    @BeforeAll
    static void init() {
        System.out.println("BEFORE ALL TESTS!");
    }

    @AfterAll
    static void after() {
        System.out.println("AFTER ALL TESTS!");
    }

    @BeforeEach
    void setUp() {
        romanToArabicConverter = new RomanToArabicConverter();
        System.out.println("BEFORE EACH TESTS!");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AFTER EACH TESTS!");
    }

    @DisplayName("Roman to arabic converter should return expected arabic number when correct rome one is passed")
    @ParameterizedTest(name = "{index}: {0} => {1}")
    @CsvSource(
            value = {"X;10;null", "V;5;test", "III;3;test", "XXVIII;28;test", "iiii;4;test4", "iV;4;test4"},
            delimiter = ';',
            emptyValue = "''",
            nullValues = "null")
    void romanToArabicShouldReturnExpectedArabicNumberWhenCorrectRomanNumberIsPassed(
            String romeNumber, int expectedArabicNumber, String test) {
        System.out.println("romanToArabicShouldReturn10WhenXRomanNumberIsPassed");
        System.out.println(null == test);

        int actualArabicNumber = romanToArabicConverter.romanToArabic(romeNumber);

        Assertions.assertEquals(
                expectedArabicNumber, actualArabicNumber, String.format("Expected value %s", expectedArabicNumber));
    }

    @ValueSource(strings = {"test", "Xtest", "null"})
    @ParameterizedTest
    @NullAndEmptySource
//    @EmptySource
//    @NullSource
    void romanToArabicShouldThrowIllegalArgumentExceptionWhenInValidRomanNumberIsPassed(String invalidRomeNumber) {
        System.out.println(invalidRomeNumber == null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> romanToArabicConverter.romanToArabic(invalidRomeNumber));
    }

    // below tests are for demonstration purpose
    @ParameterizedTest
    @EnumSource(value = RomanNumeral.class, names = {"X", "V"}, mode = EnumSource.Mode.EXCLUDE)
    void testEnumSource(RomanNumeral value) {
        System.out.println(value);
    }

    @ParameterizedTest
    @MethodSource("provideMethodSourceArgument")
    void testMethodSource(BirthDate birthDate, String temp) {
        System.out.println(birthDate);
        System.out.println(temp);
    }

    private static Stream<Arguments> provideMethodSourceArgument() {
        return Stream.of(
                Arguments.of(new BirthDate(), new String("123")),
                Arguments.of(new BirthDate(), new String("1234"))
        );
    }
}