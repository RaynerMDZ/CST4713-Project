package edu.citytech.cst.s23253396.cst4713project.grading.repositories;

import edu.citytech.cst.s23253396.cst4713project.grading.models.Grade;
import edu.citytech.cst.s23253396.cst4713project.grading.util._FileReader;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GradeRepository {

    private final _FileReader fileReader;

    public GradeRepository(_FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public Grade gradeMap(String row) {
        return new Grade(this.getId(row), this.getScores(row));
    }

    private int getId(String row) {
        String[] columns = row.split(",");
        return Integer.parseInt(columns[0]);
    }

    private Float[] getScores(String row) {
        String[] columns = row.split(",");
        int size = columns.length - 1;
        Float[] scores = new Float[size];

        for (int i = 0; i < size; i++) {
            scores[i] = Float.parseFloat(columns[i + 1]);
        }
        return scores;
    }

    public List<Grade> findAll() {
//        String csvPath = "src/main/resources/data/Students.csv";
        String csvPath = System.getenv("CST_4713_EXAM_DATA");
        List<String> list = this.fileReader.createListWithFileLines(csvPath, 1);
        return list.stream().map(this::gradeMap).collect(Collectors.toList());
    }

}
