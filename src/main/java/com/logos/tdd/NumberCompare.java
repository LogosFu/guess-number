package com.logos.tdd;

import java.util.List;

public class NumberCompare {


  public boolean compareTwo(int given, int compared) {
    return given == compared;
  }

  public boolean isNumberIn(int given, List<Integer> collect) {
    return collect.contains(given);
  }

}
