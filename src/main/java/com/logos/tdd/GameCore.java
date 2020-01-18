package com.logos.tdd;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


public class GameCore {

  @Getter
  @Setter
  private List<Integer> answers;

  private NumberCompare compare;

  public GameCore(NumberCompare compare) {
    this.compare = compare;
  }


  public String tryGuess(List<Integer> tryGuess) {
    if (isListRepeat(tryGuess) || tryGuess.size() != 4) {
      throw new InputErrorException();
    }
    final long equalCount = getNumberEqualCount(tryGuess);
    final long numberIn = tryGuess.stream().filter(guess -> compare.isNumberIn(guess, answers))
        .count();
    return equalCount + "A" + (numberIn - equalCount) + "B";
  }

  private boolean isListRepeat(List<Integer> tryGuess) {
    return tryGuess.size() > tryGuess.stream().distinct().count();
  }

  private long getNumberEqualCount(List<Integer> tryGuess) {
    return tryGuess.stream()
        .flatMap(guess -> answers.stream().filter(answer -> compare.compareTwo(guess, answer)))
        .count();
  }
}
