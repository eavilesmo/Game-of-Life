package game.of.life;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class InputConverter {

    public ArrayList<ArrayList<Integer>> reader() throws FileNotFoundException {
        File doc = new File("/home/eaviles/Desktop/game_of_life.txt");
        Scanner scanner = new Scanner(doc);

        List<String> inputText = new ArrayList<>();

        while (scanner.hasNextLine()) {
            inputText.add(scanner.nextLine());
        }

        ArrayList<ArrayList<Integer>> outputMatrix = new ArrayList<>();

        for (int index = 0; index < inputText.size(); index++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            String line = inputText.get(index);
            String[] stringOfStrings = line.split("");
            for (String element : stringOfStrings) {
                if (element.equals(".")){
                    innerList.add(0);
                }
                else if (element.equals("*")) {
                    innerList.add(1);
                }
            }
            outputMatrix.add(innerList);
        }
        return outputMatrix;
    }
}
