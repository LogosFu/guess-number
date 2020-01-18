package com.logos.tdd;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberCompareTest {

  private NumberCompare comparer;

  @BeforeEach
  void setUp() {
    comparer = NumberCompare.getInstance();
  }

  @ParameterizedTest
  @CsvSource({"1,1,true", "5,5,true", "4,6,false"})
  void should_return_result_when_number_equal_given_two_number(int given, int compared,
      boolean result) {

    assertThat(comparer.compareTwo(given, compared)).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource({"1,1234,true", "2,1234,true", "7,1234,false"})
  void should_return_result_when_check_number_in_numbers_given_numbers_and_number(int given,
      String numbers, boolean result) {

    final boolean numberIn = comparer
        .isNumberIn(given, Arrays.asList(numbers.split("")).stream().map(Integer::valueOf).collect(
            Collectors.toList()));
    assertThat(numberIn).isEqualTo(result);
  }
}