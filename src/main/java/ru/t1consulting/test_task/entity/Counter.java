package ru.t1consulting.test_task.entity;
import lombok.*;


/**
 * An entity for storing the number of each letter and outputting it as text "a": 1
 *
 */
@Getter
@AllArgsConstructor
public class Counter{

    private String letter;
    private Integer amount;

    @Override
    public String toString() {
        return '\"'+ letter + '\"' + ": " + amount;
    }

}
