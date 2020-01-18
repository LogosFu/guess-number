package com.logos.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

  private GameCore gameCore;

  @BeforeEach
  void setUp() {
    gameCore = mock(GameCore.class);
  }

  @Test
  void should_end_when_guess_given4_a_result() {
    when(gameCore.tryGuess(Arrays.asList(1, 4, 6, 8))).thenReturn("4A");
    final Game game = new Game(gameCore);
    final String result = game.play(1, 4, 6, 8);
    assertThat(result).isEqualTo("4A");
  }

  @Test
  void should_end_when_guess_over_six_given_error() {

  }
}