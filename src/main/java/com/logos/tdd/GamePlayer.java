package com.logos.tdd;

import static java.util.Arrays.stream;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;

public class GamePlayer {

  private GuessNumberGame guessNumberGame;

  public GamePlayer(GuessNumberGame guessNumberGame) {
    this.guessNumberGame = guessNumberGame;
  }

  public String play(int... numbers) {
    final List<Integer> guess = stream(numbers).boxed().collect(Collectors.toList());
    return guessNumberGame.tryGuess(guess);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String nextLine = scanner.nextLine();
    int sum = 0;
    GuessNumberGame guessNumberGame = new GuessNumberGame(new NumberCompare());
    guessNumberGame.setAnswers(getRandomNumbers());
    GamePlayer gamePlayer = new GamePlayer(guessNumberGame);

    while (nextLine != null && !nextLine.equals("")) {
      sum += 1;
      nextLine = scanner.nextLine();
      try {
        final String result = gamePlayer
            .play(stream(nextLine.split("")).mapToInt(Integer::valueOf).toArray());
        System.out.println(result);
      }catch (InputErrorException e){
        System.out.println("Wrong Input, input again");
      }

      if (sum == 6) {
        break;
      }
    }

    System.out.println("end");
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
