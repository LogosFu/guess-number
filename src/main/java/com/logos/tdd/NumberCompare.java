package com.logos.tdd;

import java.util.List;

public class NumberCompare {

  private NumberCompare() {

  }

  public static NumberCompare getInstance() {
    return NumberCompare.Inner.instance;
  }

  public boolean compareTwo(int given, int compared) {
    return given == compared;
  }

  public boolean isNumberIn(int given, List<Integer> collect) {
    return collect.contains(given);
  }

  private static class Inner {

    private static final NumberCompare instance = new NumberCompare();
  }


}
