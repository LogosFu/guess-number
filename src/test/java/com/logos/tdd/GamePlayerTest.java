package com.logos.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GamePlayerTest {

  private GuessNumberGame guessNumberGame;

  @BeforeEach
  void setUp() {
    guessNumberGame = mock(GuessNumberGame.class);
  }

  @Test
  void should_end_when_guess_given4_a_result() {
    when(guessNumberGame.tryGuess(Arrays.asList(1, 4, 6, 8))).thenReturn("4A");
    final GamePlayer gamePlayer = new GamePlayer(guessNumberGame);
    final String result = gamePlayer.play(1, 4, 6, 8);
    assertThat(result).isEqualTo("4A");
  }

  @Test
  void should_end_when_guess_over_six_given_error() {

  }
}