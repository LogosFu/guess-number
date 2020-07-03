package com.logos.tdd;

import static java.util.Arrays.stream;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;

public class GamePlayer {

  GuessNumberGame guessNumberGame;
  private final Scanner scanner;

  public GamePlayer() {
    guessNumberGame = new GuessNumberGame(new NumberCompare());
    guessNumberGame.setAnswers(getRandomNumbers());
    this.scanner = new Scanner(System.in);
  }

  public void playGame() {
    for (int count = 0; count < 6; count++) {
      try {
        String input = getInput();
        System.out.println(this.guessNumberGame
            .play(stream(input.split("")).mapToInt(Integer::valueOf).toArray()));
      } catch (InputErrorException e) {
        System.out.println("Wrong Input, input again");
      }
    }
  }

  private String getInput() {
    String nextLine = scanner.nextLine();
    if (nextLine != null && !nextLine.equals("")) {
      return nextLine;
    } else {
      throw new InputErrorException();
    }
  }

  public static List<Integer> getRandomNumbers() {
    int num = 0;
    int i = 0;
    int[] arrs = new int[4];
    while (i < 4) {
      num = (int) (Math.random() * 9);
      if (num >= 0 && !ArrayUtils.contains(arrs, num)) {
        arrs[i] = num;
        i++;
      }
    }
    return stream(arrs).boxed().collect(Collectors.toList());
  }
}
