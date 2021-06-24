package edu.citytech.cst.s23253396.cst4713project.counter123.services;

import edu.citytech.cst.s23253396.cst4713project.counter123.models.Counter123;

import java.util.List;

public interface Counter123Service {

    List<Counter123> countBy(Long number);
    List<Counter123> highlightEvenNumbers(List<Counter123> numbers);
    List<Counter123> highlightOddNumbers(List<Counter123> numbers);
    List<Counter123> highlightEveryFiveNumbers(List<Counter123> numbers);
    List<Counter123> highlightEveryTenNumbers(List<Counter123> numbers);
    List<Counter123> highlightNumbersThatContains8(List<Counter123> numbers);
    List<Counter123> selectTypeOfHighlight(String type, List<Counter123> counter123List);
}
