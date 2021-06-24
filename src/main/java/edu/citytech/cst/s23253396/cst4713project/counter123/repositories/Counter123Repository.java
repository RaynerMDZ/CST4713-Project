package edu.citytech.cst.s23253396.cst4713project.counter123.repositories;

import edu.citytech.cst.s23253396.cst4713project.counter123.models.Counter123;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

@Repository
public class Counter123Repository {

    public List<Counter123> countByUserNumber(Long number) {
        List<Counter123> counter123List = new ArrayList<>();
        if (number >= 20) {
            LongStream.iterate(0, i -> i <= 1000, i -> i + number).forEach(i -> {
                Counter123 counter123 = new Counter123();
                counter123.setNumber(i);
                counter123.setCssClass("n123-100");
                counter123List.add(counter123);
            });
        } else {
            LongStream.iterate(0, i -> i <= 1000, i -> i + number).forEach(i -> {
                Counter123 counter123 = new Counter123();
                counter123.setNumber(i);
                counter123.setCssClass("n123-001");
                counter123List.add(counter123);
            });
        }

//        LongStream.iterate(0, i -> i <= 1000, i -> i + number).forEach(i -> {
//            Counter123 counter123 = new Counter123();
//            counter123.setNumber(i);
//
//            if (number >= 20) {
//                counter123.setCssClass("n123-100");
//            } else {
//                counter123.setCssClass("n123-001");
//            }
//
//            counter123List.add(counter123);
//        });

        return counter123List;
    }
}
