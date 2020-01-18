package com.logos.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GuessTest {

  private NumberCompare compare;
  private int chart1 = 1;
  private int chart2 = 2;
  private int chart3 = 3;
  private int chart4 = 4;
  private int answer1 = 5;
  private int answer2 = 6;
  private int answer3 = 7;
  private int answer4 = 8;
  private final List<Integer> answers = Arrays.asList(answer1, answer2, answer3, answer4);
  private final List<Integer> tryGuess = Arrays.asList(chart1, chart2, chart3, chart4);
  @BeforeEach
  void setUp() {
    compare = mock(NumberCompare.class);
  }

  @Test
  void should_return_2_a_when_guess_given_four_digits_number_has_two_equal_and_in_same_index() {

    when(compare.compareTwo(chart1, answer1)).thenReturn(true);
    when(compare.compareTwo(chart2, answer2)).thenReturn(true);
    when(compare.compareTwo(chart3, answer3)).thenReturn(false);
    when(compare.compareTwo(chart4, answer4)).thenReturn(false);

    Guess guess = new Guess(compare);
    guess.setAnswers(answers);
    assertThat(guess.tryGuessEqual(tryGuess)).isEqualTo("2A");
  }

  @Test
  void should_return_1B_when_guess_given_four_digits_number_has_one_equal_and_not_in_same_index() {

    when(compare.compareTwo(chart1, answer1)).thenReturn(true);
    when(compare.compareTwo(chart2, answer2)).thenReturn(true);
    when(compare.compareTwo(chart3, answer3)).thenReturn(false);
    when(compare.compareTwo(chart4, answer4)).thenReturn(false);
    when(compare.isNumberIn(chart1, answers)).thenReturn(true);
    when(compare.isNumberIn(chart2, answers)).thenReturn(true);
    when(compare.isNumberIn(chart3, answers)).thenReturn(true);
    when(compare.isNumberIn(chart4, answers)).thenReturn(false);


    Guess guess = new Guess(compare);
    guess.setAnswers(answers);
    assertThat(guess.tryGuessNumberIn(tryGuess)).isEqualTo("1B");
  }
}