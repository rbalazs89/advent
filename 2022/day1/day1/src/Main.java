import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {
    public static void main(String[] args) {
        List<String> deerCalories = readFile("src/deercalories.csv");

        String oneString = "";
        for (int i = 0; i < deerCalories.size(); i++) {
            if(deerCalories.get(i).equals("")){
                deerCalories.remove(i);
                deerCalories.add(i,"0");
            }
        }

        ArrayList <Integer> deerCaloriesNumbers = new ArrayList();
        for (int i = 0; i < deerCalories.size(); i++) {
            deerCaloriesNumbers.add(Integer.parseInt(deerCalories.get(i)));
        }

        System.out.println(deerCaloriesNumbers);

        ArrayList<Integer> FinalDeerData = new ArrayList<>();


        int j = 0;
        int tempValue = 0;
        for (int i = 0; i<deerCaloriesNumbers.size();i++){
            if(deerCaloriesNumbers.get(i) !=0){
                tempValue += deerCaloriesNumbers.get(i);
            }
            else{
                FinalDeerData.add(tempValue);
                tempValue = 0;
            }
        }
        System.out.println(deerCaloriesNumbers);
        System.out.println(FinalDeerData);
        for(int k = 0; k<FinalDeerData.size();k++) {
            for (int i = 0; i < FinalDeerData.size() - 1; i++) {
                int tempHolder = 0;
                if (FinalDeerData.get(i) > FinalDeerData.get(i + 1)) {
                    tempHolder = FinalDeerData.get(i);
                    FinalDeerData.set(i, FinalDeerData.get(i + 1));
                    FinalDeerData.set(i + 1, tempHolder);
                }
            }
        }
        System.out.println(FinalDeerData);


    }




    public static List<String> readFile(String file){
        Path filePath = Paths.get(file);
        try{
            List<String> fileLines = Files.readAllLines(filePath);
            return fileLines;
        }
        catch (IOException e){
            System.err.println("beep beep error");
            return new ArrayList<>();
        }
    }
}