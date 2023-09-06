package org.example;



import lombok.AllArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
@AllArgsConstructor
public  class EngGame extends AbstractGame {

    public String readFile() throws IOException {
        ArrayList<String> store = new ArrayList<>();
        ArrayList<String> sortedList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Sasha\\Desktop\\HW3\\HomeWork03\\src\\main\\java\\org\\example\\ListWordEng.txt")));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] splitLine = line.split(" ");

            store.addAll(Arrays.asList(splitLine));
        }
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).length() == 6) {
                sortedList.add(store.get(i));
            }
        }
        Random random = new Random();
        String result = " ";
        for (int i = 0; i < sortedList.size(); i++) {
            int index = (random.nextInt(sortedList.size()));
            result = sortedList.get(index);
            sortedList.remove(index);
        }
        return result;
    }


    @Override
    protected List<String> generateCharList() {
        return null;
    }
}

