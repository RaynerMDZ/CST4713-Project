package edu.citytech.cst.s23253396.cst4713project.grading.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for _File Reader")
class _FileReaderTest {

    private final _FileReader fileReader = new _FileReader();
    private final String CSV_FILE = "src/main/resources/data/Students.csv";

    @BeforeEach
    void setUp() {
    }

    @Test
    void printFileLineByLine() {

    }

    @Test
    void createListWithFileLines() {
        var expected = 141;
        var actual = this.fileReader.createListWithFileLines(this.CSV_FILE).size();
        assertEquals(expected, actual);
    }

    @Test
    void CreateListWithFileLinesSkip1() {
        var expected = 140;
        var actual = this.fileReader.createListWithFileLines(this.CSV_FILE, 1).size();
        assertEquals(expected, actual);
    }
}