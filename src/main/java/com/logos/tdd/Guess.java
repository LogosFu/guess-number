package com.logos.tdd;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


public class Guess {

  @Getter
  @Setter
  private List<Integer> answers;

  private NumberCompare compare;

  public Guess(NumberCompare compare) {
    this.compare = compare;
  }

  public String tryGuessEqual(List<Integer> tryGuess) {
    final long count = getNumberEqualCount(tryGuess);
    return count + "A";
  }

  public String tryGuessNumberIn(List<Integer> tryGuess) {
    final long numberIn = tryGuess.stream().filter(guess -> compare.isNumberIn(guess, answers))
        .count();
    return (numberIn - getNumberEqualCount(tryGuess)) + "B";
  }

  private long getNumberEqualCount(List<Integer> tryGuess) {
    return tryGuess.stream()
        .flatMap(guess -> answers.stream().filter(answer -> compare.compareTwo(guess, answer)))
        .count();
  }
}
