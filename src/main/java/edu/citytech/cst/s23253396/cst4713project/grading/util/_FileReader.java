package edu.citytech.cst.s23253396.cst4713project.grading.util;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class _FileReader {

    public void printFileLineByLine(String csvFile) {

        try (BufferedReader br = Files.newBufferedReader(Paths.get(csvFile))) {
            br.lines()
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> createListWithFileLines(String csvFile) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(csvFile))) {
            return br.lines()
                    .collect(Collectors.toList());

        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public List<String> createListWithFileLines(String csvFile, int skip) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(csvFile))) {
            return br.lines()
                    .skip(skip)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
