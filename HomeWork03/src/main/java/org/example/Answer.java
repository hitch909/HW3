package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Answer {
    private String userInput;
    private Integer bull;
    private Integer cow;

    public void showAnswer(){
        System.out.println("было введено слово: " + userInput + ", совпадений:  "+ cow+ ", полных совпадений:  "+ bull);
    }
}
