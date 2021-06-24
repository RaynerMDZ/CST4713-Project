package edu.citytech.cst.s23253396.cst4713project.abccounter.services;

import edu.citytech.cst.s23253396.cst4713project.abccounter.models.Abc;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class AbcCounterService {

    public List<Abc> getAbcUppercase() {
        List<Abc> list = new ArrayList<>();

        int index = 0;
        for (var ch = 'A'; ch <= 'Z'; ch++) {
            list.add(new Abc(ch, ++index, "abc-bigger"));
        }

        return this.applyVowelAndConsonantCssStyle(list);
    }

    public List<Abc> getAbcLowercase() {
        List<Abc> list = new ArrayList<>();

        int index = 0;
        for (var ch = 'a'; ch <= 'z'; ch++) {
            list.add(new Abc(ch, ++index, "abc-bigger"));
        }

        return this.applyVowelAndConsonantCssStyle(list);
    }

    public List<Abc> getAll() {
        List<Abc> list = new ArrayList<>();

        int index = 0;
        for (var ch = 'A'; ch <= 'Z'; ch++) {
            list.add(new Abc(ch, ++index, "abc"));
        }

        for (var ch = 'a'; ch <= 'z'; ch++) {
            list.add(new Abc(ch, ++index, "abc"));
        }

        return this.applyVowelAndConsonantCssStyle(list);
    }

    public List<Abc> applyVowelAndConsonantCssStyle(List<Abc> abcList) {
        List<Abc> list = new ArrayList<>();
        for (Abc letter : abcList) {
            if (Stream.of("a", "e", "i", "o", "u")
                    .parallel()
                    .anyMatch(letter.getLetter().toString()::equalsIgnoreCase)) {
                letter.setHtmlClass(letter.getHtmlClass() + " vowel");
            } else {
                letter.setHtmlClass(letter.getHtmlClass() + " consonant");
            }
            list.add(letter);
        }
        return list;
    }

    public List<Abc> selectAlphabetMode(String mode) {

        if (mode.equalsIgnoreCase("uppercase")) {
            return this.getAbcUppercase();
        }

        if (mode.equalsIgnoreCase("lowercase")) {
            return this.getAbcLowercase();
        }

        if (mode.equalsIgnoreCase("allReversed")) {
            return this.reverse(this.getAll());
        }

        if (mode.equalsIgnoreCase("uppercaseReversed")) {
            return this.reverse(this.getAbcUppercase());
        }

        if (mode.equalsIgnoreCase("lowercaseReversed")) {
            return this.reverse(this.getAbcLowercase());
        }

        return this.getAll();
    }

    private <T> List<T> reverse(final List<T> list) {
        final int last = list.size() - 1;
        return IntStream.rangeClosed(0, last)     // a stream of all valid indexes into the list
                .parallel()
                .map(i -> (last - i))             // reverse order
                .mapToObj(list::get)              // map each index to a list element
                .collect(Collectors.toList());    // wrap them up in a list
    }
}
