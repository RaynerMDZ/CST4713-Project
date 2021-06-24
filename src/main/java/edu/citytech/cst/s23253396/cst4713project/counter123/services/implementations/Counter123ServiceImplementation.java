package edu.citytech.cst.s23253396.cst4713project.counter123.services.implementations;

import edu.citytech.cst.s23253396.cst4713project.counter123.models.Counter123;
import edu.citytech.cst.s23253396.cst4713project.counter123.repositories.Counter123Repository;
import edu.citytech.cst.s23253396.cst4713project.counter123.services.Counter123Service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Counter123ServiceImplementation implements Counter123Service {

    private final Counter123Repository repository;

    public Counter123ServiceImplementation(Counter123Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<Counter123> countBy(Long number) {
        return this.repository.countByUserNumber(number);
    }

    @Override
    public List<Counter123> highlightEvenNumbers(List<Counter123> numbers) {

        List<Counter123> counter123List = new ArrayList<>();

        numbers.forEach(counter -> {
            if (counter.getNumber() % 2 == 0) {
                counter.setCssClass(counter.getCssClass() + " highlight");
            }
            counter123List.add(counter);
        });

        return counter123List;
    }

    @Override
    public List<Counter123> highlightOddNumbers(List<Counter123> numbers) {

        List<Counter123> counter123List = new ArrayList<>();

        numbers.forEach(counter -> {
            if (counter.getNumber() % 2 != 0) {
                counter.setCssClass(counter.getCssClass() + " highlight");
            }
            counter123List.add(counter);
        });

        return counter123List;
    }

    @Override
    public List<Counter123> highlightEveryFiveNumbers(List<Counter123> numbers) {

        List<Counter123> counter123List = new ArrayList<>();
        int count = 0;

        for (Counter123 counter : numbers) {
            if (count % 5 == 0) {
                counter.setCssClass(counter.getCssClass() + " highlight");
            }
            counter123List.add(counter);
            count++;
        }

        return counter123List;
    }

    @Override
    public List<Counter123> highlightEveryTenNumbers(List<Counter123> numbers) {

        List<Counter123> counter123List = new ArrayList<>();
        int count = 0;

        for (Counter123 counter : numbers) {
            if (count % 10 == 0) {
                counter.setCssClass(counter.getCssClass() + " highlight");
            }
            counter123List.add(counter);
            count++;
        }

        return counter123List;
    }

    @Override
    public List<Counter123> highlightNumbersThatContains8(List<Counter123> numbers) {

        List<Counter123> counter123List = new ArrayList<>();

        numbers.forEach(counter -> {
            String number = String.valueOf(counter.getNumber());
            if (number.contains("8")) {
                counter.setCssClass(counter.getCssClass() + " highlight");
            }
            counter123List.add(counter);
        });

        return counter123List;
    }

    @Override
    public List<Counter123> selectTypeOfHighlight(String type, List<Counter123> counter123List) {
        if (type.equalsIgnoreCase("even")) {
            return this.highlightEvenNumbers(counter123List);
        }

        if (type.equalsIgnoreCase("odd")) {
            return this.highlightOddNumbers(counter123List);
        }

        if (type.equalsIgnoreCase("every.5")) {
            return this.highlightEveryFiveNumbers(counter123List);
        }

        if (type.equalsIgnoreCase("every.10")) {
            return this.highlightEveryTenNumbers(counter123List);
        }

        if (type.equalsIgnoreCase("contains.8")) {
            return this.highlightNumbersThatContains8(counter123List);
        }

        return counter123List;
    }
}
