package com.logos.tdd;

import static java.util.Arrays.stream;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;


public class GuessNumberGame {

  @Getter
  @Setter
  private List<Integer> answers;

  private NumberCompare compare;

  public GuessNumberGame(NumberCompare compare) {
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

  public String play(int... numbers) {
    final List<Integer> guess = stream(numbers).boxed().collect(Collectors.toList());
    return tryGuess(guess);
  }
}
